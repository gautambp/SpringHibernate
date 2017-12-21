package self.learning.spring.basic;

public class Person {
	private int id;
	private String name;
	private String prop;
	private Address address;
	
	public Person() {
		this.id = 55;
		this.name = "Hello World";
	}
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
		System.out.println("Inside Person constructor : " + this);
	}
	public static Person createPerson(int id, String name) {
		Person p = new Person(id, name);
		System.out.println("Creating person inside a factory method : " + p);
		return p;
	}
	public void init() {
		System.out.println("Person init : " + this);
	}
	public void onDestroy() {
		System.out.println("Person getting destroyed : " + this);
	}
	public String getProp() {
		return prop;
	}
	public void setProp(String prop) {
		this.prop = prop;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", prop=" + prop
				+ ", address=" + address + "]";
	}
}
