package self.learning.spring.spel;

import java.util.Random;

public class RandomText {

	private static String[] texts = {
		"Hello World", "HW", "HeWo"
	};
	
	public String getText() {
		Random r = new Random();
		return texts[r.nextInt(texts.length)];
	}
}
