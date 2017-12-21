package self.learning.spring.basic;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("self/learning/spring/basic/beans.xml");
    	Person p1 = (Person) ctx.getBean("person");
        System.out.println("person 1 = " + p1);
        Person p2 = (Person) ctx.getBean("person");
        System.out.println("person 2 = " + p2);
        System.out.println("Is person 1 = person 2 ? " + (p1 == p2));
        System.out.println("Is person 1 address = person 2 address ? " + (p1.getAddress() == p2.getAddress()));
        System.out.println("Closing context");
        p1 = null;
        Address a2 = (Address) ctx.getBean("addressWithNS");
        System.out.println(a2);
        FruitBasket fb = (FruitBasket) ctx.getBean("fruitBasket");
        System.out.println(fb);
        ctx.close();
        System.out.println("Context closed");
    }
}
