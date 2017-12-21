package self.learning.spring_aop;

import org.springframework.stereotype.Component;

@Component
public class Camera {
	public void snap() {
		System.out.println("SNAP");
	}
	public void sayCheese() {
		System.out.println("Cheese");
	}
	public void sayCheese(int duration) {
		System.out.println("Cheese for seconds - " + duration);
	}
	public String sayCheese(String msg) {
		System.out.println("Cheese with msg - " + msg);
		return msg;
	}
	public void snapWithException() throws Exception {
		System.out.println("Inside snapWithException");
		throw new Exception("Some exception");
	}
	public void snapWithoutException() throws Exception {
		System.out.println("Inside snapWithoutException");
		//throw new Exception("Some exception");
	}
	public void snapWithAround() {
		System.out.println("Inside snapWithAround");
	}
}
