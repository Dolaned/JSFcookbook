package beans;

import ht.HibernateUtil;
import ht.Ingredient;

import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


@ManagedBean
public class ingredientBean {
	private Integer amount;
	private String unit;
	private String name;
	
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
	
	public void addIngredient(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = null;
		Transaction transaction = null;
		session = sf.openSession();
		transaction = session.beginTransaction();
		
		Ingredient i = new Ingredient();
		i.setName(this.name);
		i.setAmount(this.amount);
		i.setUnit(this.unit);
		session.save(i);
		transaction.commit();
	}
	
	
}
