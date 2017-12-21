package self.learning.spring.basic;

public class Address {
	private String street;
	private String city;
	
	public void init() {
		System.out.println("Address init : " + this);
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + "]";
	}
	
}
