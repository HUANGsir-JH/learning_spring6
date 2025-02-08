public interface BeanContainer {
    public void registerBean(String beanName, Class<?> beanClass);
    public Object getBean(String beanName);
}
