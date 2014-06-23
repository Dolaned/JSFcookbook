package ht;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {
	public static void main(String[] args){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = null;
		Transaction transaction = null;
		session = sf.openSession();
		transaction = session.beginTransaction();
		
		Ingredient i = new Ingredient();
		i.setName("Stones");
		i.setAmount(5);
		i.setUnit("kg");
		session.save(i);
		
		Ingredient i2 = new Ingredient();
		i2.setName("Water");
		i2.setAmount(1);
		i2.setUnit("liter");
		session.save(i2);
		
		Utensil u = new Utensil();
		u.setName("Cauldron");
		session.save(u);

		Recipe r = new Recipe();		
		r.setHeading("Stonesoup");
		r.setDescription("A soup made from stones and water.");
		r.setDifficulty("hard");
		r.setTime(5);
		Set<Ingredient> contents = new LinkedHashSet<Ingredient>();
		contents.add(i);
		contents.add(i2);
		r.setIngredients(contents);
		Set<Utensil> tools = new LinkedHashSet<Utensil>();
		tools.add(u);
		r.setUtensils(tools);
		session.save(r);
		transaction.commit();
		
		Iterator<Printable> it = session.createQuery("from Recipe").list().iterator();
		while( it.hasNext() ){
			System.out.println(it.next().getInfo()+System.lineSeparator());
		}
		
		System.exit(0);
	}
}
