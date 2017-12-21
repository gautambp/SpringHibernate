package self.learning.spring.basic;

import java.util.List;
import java.util.Set;

public class FruitBasket {
	private List<String> fruits;
	private Set<String> vegs;
	
	public FruitBasket() {
		this.fruits = null;
	}

	public List<String> getFruits() {
		return fruits;
	}

	public void setFruits(List<String> fruits) {
		this.fruits = fruits;
	}

	public Set<String> getVegs() {
		return vegs;
	}

	public void setVegs(Set<String> vegs) {
		this.vegs = vegs;
	}

	@Override
	public String toString() {
		return "FruitBasket [fruits=" + fruits + ", vegs=" + vegs + "]";
	}
	
}
