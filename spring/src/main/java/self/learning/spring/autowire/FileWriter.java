package self.learning.spring.autowire;

public class FileWriter implements LogWriter {
	public void write(String text) {
		System.out.println("FileWrite : " + text);
	}
}
