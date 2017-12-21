package self.learning.spring.basic;

public class PersonFactory {
	public Person createPerson(int id, String name) {
		Person p = new Person(id, name);
		System.out.println("Creating person inside a factory bean : " + p);
		return p;
	}
}
