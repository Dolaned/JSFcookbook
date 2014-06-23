package ht;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Utensil implements Printable {
	private String name;
	
	public Utensil(){
		setName("");
	}

	@Id
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	@Transient
	public String getInfo() {
		return getName();
	}
}
