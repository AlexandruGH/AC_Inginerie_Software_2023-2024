
public class WriteService {

	private final Writer writer;
	
	public WriteService(Writer writer) {
		this.writer = writer;
	}
	
	void write(String stuff) {
		writer.writeSomething(stuff);
	}
	
}
