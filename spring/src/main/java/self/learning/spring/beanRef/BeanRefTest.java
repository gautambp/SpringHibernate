package self.learning.spring.beanRef;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class BeanRefTest 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("self/learning/spring/beanRef/beans.xml");
    	Jungle j = (Jungle) ctx.getBean("jungle");
    	System.out.println(j);
        ctx.close();
    }
}
