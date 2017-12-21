package self.learning.spring.annotation;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class BeanLogger {
	private ConsoleWriter consoleWriter;
	private FileWriter fileWriter;
	private String message;

	@Inject
	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}
	
	@Inject
	public void setFileWriter(FileWriter logWriter) {
		this.fileWriter = logWriter;
	}

	@Autowired
	public void setMessage(@Value("Hello World") String msg) {
		this.message = msg;
	}
	
	public void writeFile(String text) {
		fileWriter.write(text);
	}

	public void writeConsole(String text) {
		consoleWriter.write(text);
	}
	
	public void printMessage() {
		System.out.println(this.message);
	}
}
