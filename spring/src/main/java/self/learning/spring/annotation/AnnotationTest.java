package self.learning.spring.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"self/learning/spring/annotation/beans.xml");
		Logger l = (Logger) ctx.getBean("logger");
		l.writeConsole("message for console");
		l.writeFile("message for file");
		ResourceLogger rl = (ResourceLogger) ctx.getBean("resourceLogger");
		rl.writeConsole("message for console from resource logger");
		rl.writeFile("message for file from resource logger");
		InjectLogger il = (InjectLogger) ctx.getBean("injectLogger");
		il.writeConsole("message for console from inject logger");
		il.writeFile("message for file from inject logger");
		BeanLogger bl = (BeanLogger) ctx.getBean("beanLogger");
		bl.writeConsole("message for console from bean logger");
		bl.writeFile("message for file from bean logger");
		bl.printMessage();
		ctx.close();
	}
}
