package Platform.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderLoggingAspect {
    
    // 注解类型
    // 1. 前置通知：在目标方法执行前执行 -> @Before()
    // 2. 后置通知：在目标方法执行后执行 -> @After()
    // 3. 环绕通知：在目标方法执行前后都会执行 -> @Around()
    // 4. 异常通知：在目标方法出现异常时执行 -> @AfterThrowing()
    // 5. 返回通知：在目标方法执行完毕后执行 -> @AfterReturning()
    // 6. 切入点复用：定义切入点表达式 -> @Pointcut()
    // 7. 设定优先级：设置切面优先级，数字越小优先级越高 -> @Order(1)
    
    // 记录订单创建或者取消的日志
    
    // 在OrderService.createOrder()方法返回时执行
    @AfterReturning(pointcut = "execution(* Platform.service.OrderInter.createOrder(..))",
            returning = "orderID")
    public void logOrderCreation(JoinPoint jp,Object orderID){
        Object[] args = jp.getArgs();
        System.out.printf("[订单日志] 用户%s在商家%s创建订单：%s 商品：%s%n",
                args[0], args[1], orderID, args[2]);
    }
    
    // 在OrderService.cancelOrder()方法执行前执行
    @AfterReturning("execution(* Platform.service.OrderInter.cancelOrder(..))")
    public void logOrderCancellation(JoinPoint jp){
        System.out.printf("[订单日志] 取消订单：%s%n",
                jp.getArgs()[0]);
    }
    
}
