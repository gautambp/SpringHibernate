package self.learning.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Logger {
	private ConsoleWriter consoleWriter;
	@Autowired
	@Qualifier("taggedConsoleWriter")
	private LogWriter consoleWriter2;
	@Autowired
	private FileWriter fileWriter;
	@Autowired(required = false)
	private FileWriter fileWriter2;

	@Autowired
	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}

	public void writeFile(String text) {
		if (fileWriter2 != null)
			fileWriter2.write(text);
		fileWriter.write(text);
	}

	public void writeConsole(String text) {
		if (consoleWriter2 != null)
			consoleWriter2.write(text);
		consoleWriter.write(text);
	}
}
