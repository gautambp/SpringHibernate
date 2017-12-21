package self.learning.spring.autowire;

public class BasicLogger {
	private LogWriter consoleWriter;
	private LogWriter fileWriter;
	
	public BasicLogger(ConsoleWriter c, FileWriter f) {
		this.consoleWriter = c;
		this.fileWriter = f;
	}
	
	public void writeFile(String text) {
		fileWriter.write(text);
	}
	
	public void writeConsole(String text) {
		consoleWriter.write(text);
	}
}
