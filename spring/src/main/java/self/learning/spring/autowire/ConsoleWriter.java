package self.learning.spring.autowire;

public class ConsoleWriter implements LogWriter {
	public void write(String text) {
		System.out.println("ConsoleWriter : " + text);
	}
}
