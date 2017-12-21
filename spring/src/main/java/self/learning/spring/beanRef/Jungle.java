package self.learning.spring.beanRef;

import java.util.List;
import java.util.Map;

public class Jungle {
	private Animal largest;
	private List<Animal> animals;
	private Map<String, String> foods;
	private Map<String, Animal> deadlyAnimals;
	
	public Animal getLargest() {
		return largest;
	}
	public void setLargest(Animal largest) {
		this.largest = largest;
	}
	public List<Animal> getAnimals() {
		return animals;
	}
	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}
	public Map<String, String> getFoods() {
		return foods;
	}
	public void setFoods(Map<String, String> foods) {
		this.foods = foods;
	}
	public Map<String, Animal> getDeadlyAnimals() {
		return deadlyAnimals;
	}
	public void setDeadlyAnimals(Map<String, Animal> deadlyAnimals) {
		this.deadlyAnimals = deadlyAnimals;
	}
	@Override
	public String toString() {
		return "Jungle [largest=" + largest + ",\n\tanimals=" + animals
				+ ",\n\tfoods=" + foods + ",\n\tdeadlyAnimals=" + deadlyAnimals + "]";
	}
}
