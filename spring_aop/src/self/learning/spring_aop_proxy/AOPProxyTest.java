package self.learning.spring_aop_proxy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPProxyTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("self/learning/spring_aop_proxy/beans.xml");
		Object c1 = ctx.getBean("camera");
		System.out.println("class of camera bean: " + c1.getClass());
		System.out.println("Is camera bean instance of Camera: " + (c1 instanceof Camera));
		System.out.println("Is camera bean instance of SnapTaker: " + (c1 instanceof SnapTaker));
		if (c1 instanceof Camera) {
			System.out.println("Since proxy is of type camera, calling sayCheese method");
			((Camera) c1).sayCheese(); 
			((Camera) c1).methodWithAnnotation(); 
			((Camera) c1).methodWithParams(1, 2.0d); 
		}
		if (c1 instanceof SnapTaker) {
			System.out.println("Since proxy is of type SnapTaker, calling snap method");
			((SnapTaker) c1).snap();
		}
		
		ctx.close();
	}
}
