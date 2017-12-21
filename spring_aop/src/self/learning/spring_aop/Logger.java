package self.learning.spring_aop;

import org.springframework.stereotype.Component;

@Component
public class Logger {

	public void aboutToTakePhoto() {
		System.out.println("About to take photo...");
	}

	public void justTookPhoto() {
		System.out.println("Just took the photo...");
	}
}
