package self.learning.spring.spel;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SPELTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"self/learning/spring/spel/beans.xml");
		Robot r = (Robot) ctx.getBean("robot");
		System.out.println(r);
		Robot2 r2 = (Robot2) ctx.getBean("robot2");
		System.out.println(r2);
		ctx.close();
	}

}
