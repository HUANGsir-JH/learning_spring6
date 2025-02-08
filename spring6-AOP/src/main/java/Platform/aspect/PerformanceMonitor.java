package Platform.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class PerformanceMonitor {
    // 创建一个Logger->记录日志
    private static final Logger logger = Logger.getLogger(PerformanceMonitor.class.getName());
    
    @Around("execution(* Platform.service.*.*(..))")
    public Object monitorPerformance(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        String methodName=pjp.getSignature().getName();
        try {
            return pjp.proceed();
        }finally {
            long duration = System.currentTimeMillis() - start;
            logger.info("执行方法: "+methodName+" 耗时: "+duration+"ms");
            
            // 如果耗时超过5000ms，记录为警告
            if(duration>5000){
                logger.warning("[性能警报] 方法"+methodName+"执行时间超过5000ms");
            }
        }
    }
}
