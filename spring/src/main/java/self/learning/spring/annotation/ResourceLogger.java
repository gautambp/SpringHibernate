package self.learning.spring.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;


public class ResourceLogger {
	private ConsoleWriter consoleWriter;
	private LogWriter fileWriter;

	@Resource
	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}
	
	@Resource
	public void setFileWriter(LogWriter logWriter) {
		this.fileWriter = logWriter;
	}

	public void writeFile(String text) {
		fileWriter.write(text);
	}

	public void writeConsole(String text) {
		consoleWriter.write(text);
	}
	
	@PostConstruct
	public void onInit() {
		System.out.println("Initializing the bean");
	}
	
	@PreDestroy
	public void onDestroy() {
		System.out.println("Destroying the bean");
	}
}
