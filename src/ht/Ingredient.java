package ht;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@ManagedBean
public class Ingredient implements Printable {
	private Integer amount;
	private String unit;
	private String name;
	private int id;
	
	public Ingredient(){
		setAmount(0);
		setUnit("");
		setName("");
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	@Transient
	public String getInfo() {
		return getName()+": id="+getId()+" amount="+getAmount()+getUnit();
	}
}
