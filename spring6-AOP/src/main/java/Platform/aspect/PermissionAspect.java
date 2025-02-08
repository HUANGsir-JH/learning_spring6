package Platform.aspect;

import Platform.annotation.RequiresRole;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PermissionAspect {
    // 记录当前线程的角色
    private static final ThreadLocal<String> currentRole = new ThreadLocal<>();
    
    @Before("@annotation(requiresRole)")
    public void checkPermission(JoinPoint jp, RequiresRole requiresRole){
        String requiredRole = requiresRole.value();//获取注解中的角色
        String role = currentRole.get() != null ? currentRole.get() : "USER";//获取当前线程的角色
        
        if(!requiredRole.equalsIgnoreCase(role)){
            System.out.printf("[权限校验] 用户角色: %s 不满足角色要求: %s%n",role,requiredRole);
            throw new RuntimeException("当前用户: "+role+" 需要角色: "+requiredRole);
        }
        
        System.out.printf("[权限校验] 用户角色: %s 满足角色要求: %s%n",role,requiredRole);
    }
    
    public static void setCurrentRole(String role){
        currentRole.set(role);
    }
    
    public static void removeCurrentRole(){
        currentRole.remove();
    }
}
