package self.learning.spring_aspect;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("self/learning/spring_aspect/beans.xml");
		IBlender c1 = (IBlender) ctx.getBean("blender");
		c1.blend();
		((IMachine) c1).start();
		IFan f = (IFan) ctx.getBean("fan");
		f.activate();
		((IMachine) f).start();
		ctx.close();
	}
}
