package self.learning.spring.annotation;

import javax.inject.Inject;
import javax.inject.Named;



public class InjectLogger {
	private ConsoleWriter consoleWriter;
	private LogWriter fileWriter;

	@Inject
	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}
	
	@Inject
	@Named(value="fileWriter")
	public void setFileWriter(LogWriter logWriter) {
		this.fileWriter = logWriter;
	}

	public void writeFile(String text) {
		fileWriter.write(text);
	}

	public void writeConsole(String text) {
		consoleWriter.write(text);
	}
}
