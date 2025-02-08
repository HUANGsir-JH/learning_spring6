package Platform.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "Platform")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
}
