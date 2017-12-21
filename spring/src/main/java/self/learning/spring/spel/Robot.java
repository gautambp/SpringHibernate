package self.learning.spring.spel;

public class Robot {
	private String id = "default";
	private String speech = "hello";
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setSpeech(String speech) {
		this.speech = speech;
	}
	
	@Override
	public String toString() {
		return "Robot [id=" + id + ", speech=" + speech + "]";
	}
	
}
