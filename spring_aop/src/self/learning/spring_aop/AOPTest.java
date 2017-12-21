package self.learning.spring_aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("self/learning/spring_aop/beans.xml");
		Camera c = (Camera) ctx.getBean("camera");
		c.snap();
		c.sayCheese();
		c.sayCheese(10);
		c.sayCheese("Hello!!");
		HighSpeedCamera hsc = (HighSpeedCamera) ctx.getBean("highSpeedCamera");
		hsc.snap();
		try {
			c.snapWithException();
		} catch (Exception e) {
		}
		try {
			c.snapWithoutException();
		} catch (Exception e) {
		}
		c.snapWithAround();
		ctx.close();
	}
}
