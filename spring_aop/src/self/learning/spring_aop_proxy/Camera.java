package self.learning.spring_aop_proxy;

import org.springframework.stereotype.Component;

@Component("camera")
public class Camera implements SnapTaker {

	public void snap() {
		System.out.println("Inside Camera.snap()");
	}
	public void sayCheese() {
		System.out.println("Inside Camera.sayCheese()");
	}
	@Deprecated
	public void methodWithAnnotation() {
		System.out.println("Inside Camera.methodWithAnnotation()");
	}
	public void methodWithParams(int i, double d) {
		System.out.println("Inside methodWithParams");
	}
}
