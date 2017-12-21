package self.learning.spring_aop;

import org.springframework.stereotype.Component;

@Component
public class HighSpeedCamera {
	public void snap() {
		System.out.println("HighSpeedCamera SNAP");
	}
	public void sayCheese() {
		System.out.println("HighSpeedCamera Cheese");
	}
	public void sayCheese(int duration) {
		System.out.println("HighSpeedCamera Cheese for seconds - " + duration);
	}
	public String sayCheese(String msg) {
		System.out.println("HighSpeedCamera Cheese with msg - " + msg);
		return msg;
	}
}
