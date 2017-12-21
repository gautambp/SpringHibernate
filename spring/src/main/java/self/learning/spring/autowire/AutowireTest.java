package self.learning.spring.autowire;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class AutowireTest 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("self/learning/spring/autowire/beans.xml");
    	Logger l = (Logger) ctx.getBean("logger");
    	l.writeConsole("console message");
    	l.writeFile("file message");
    	GenericLogger gl = (GenericLogger) ctx.getBean("genericLogger");
    	gl.writeConsole("console message for generic logger");
    	gl.writeFile("file message for generic logger");
    	BasicLogger bl = (BasicLogger) ctx.getBean("basicLogger");
    	bl.writeConsole("console message for basic logger");
    	bl.writeFile("file message for basic logger");
        ctx.close();
    }
}
