
public class ServiceFactory {

	private final WriteService writeService;
	private final ConsoleWriter consoleWriter;
	private final FileWriter fileWriter;
		
	ServiceFactory(){ 
		consoleWriter = new ConsoleWriter();
		fileWriter = new FileWriter();
		writeService = new WriteService(getConsoleWriter());
	}

	public WriteService getWriterService() {
		return writeService;
	}

	public ConsoleWriter getConsoleWriter() {
		return consoleWriter;
	}

	public FileWriter getFileWriter() {
		return fileWriter;
	}
	
}
