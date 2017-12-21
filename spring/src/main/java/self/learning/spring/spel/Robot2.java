package self.learning.spring.spel;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Robot2 {
	private String id = "default";
	private String speech = "hello";
	private float number = 0;
	private Date date = null;
	
	@Autowired
	public void setId(@Value("#{randomText.text.length()}") String id) {
		this.id = id;
	}
	
	@Autowired
	public void setSpeech(@Value("#{'My name is ' + randomText.getText()}") String speech) {
		this.speech = speech;
	}
	
	@Autowired
	public void setNumber(@Value("#{T(Math).PI}") float number) {
		this.number = number;
	}

	@Autowired
	public void setDate(@Value("#{new java.util.Date()}") Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Robot2 [id=" + id + ", speech=" + speech + ", number=" + number
				+ ", date=" + date + "]";
	}
	
}
