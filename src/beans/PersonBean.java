package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class PersonBean {
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String firstName) {
		this.name = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
