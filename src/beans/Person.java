package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Person {
	private String name;
	private int age;
	private Person partner;
	
	
	public Person() {
		
	}
	
	public Person(String s1, int y) {
		name = s1;
		age = y;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String firstName) {
		this.name = firstName;
	}

	public Person getPartner() {
		return partner;
	}
	public void setPartner(Person partner) {
		this.partner = partner;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	

}
