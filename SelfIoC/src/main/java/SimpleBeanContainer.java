import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;

public class SimpleBeanContainer implements BeanContainer {
    // bean与class的映射关系
    private final HashMap<String,Class<?>> beanMap=new HashMap<>();
    // 存储单例bean
    private final HashMap<String,Object> beanCache=new HashMap<>();
    
    // 注册bean
    @Override
    public void registerBean(String beanName, Class<?> beanClass) {
        beanMap.put(beanName,beanClass);
    }
    
    // 获取bean
    @Override
    public Object getBean(String beanName) {
        if(beanCache.containsKey(beanName)){
            return beanCache.get(beanName);
        }
        
        Class<?> beanClass=beanMap.get(beanName);
        if(beanClass==null){
            throw new RuntimeException("Bean not found");
        }
        
        try{
            Constructor<?> constructor = beanClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            Object beanInstance = constructor.newInstance();
            injectField(beanInstance);
            beanCache.put(beanName,beanInstance);
            return beanInstance;
        }catch (Exception e){
            throw new RuntimeException("Bean ("+beanName+") create error");
        }
    }
    
    // 属性注入
    private void injectField(Object beanInstance){
        Field[] fields = beanInstance.getClass().getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            if (beanMap.containsKey(fieldName)) {
                Object fieldBean = getBean(fieldName);
                field.setAccessible(true);
                try {
                    field.set(beanInstance, fieldBean);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Field inject error");
                }
            } else {
                field.setAccessible(true);
                try {
                    Object fieldBean = field.getClass().newInstance();
                    field.set(beanInstance, fieldBean);
                } catch (Exception e) {
                    throw new RuntimeException("Field inject error");
                }
            }
        }
    }
    
}
