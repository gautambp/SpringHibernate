package self.learning.spring_rest.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableAutoConfiguration
//@ComponentScan("self.learning.spring_rest")
@EnableWebMvc
public class AppConfig {

}
