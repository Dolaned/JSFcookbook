package ht;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Recipe implements Printable{
	private String heading;
	private String description;
	private Set<Ingredient> ingredients;
	private Integer time;
	private String difficulty;
	private Set<Utensil> utensils;
	private int id;
	
	public Recipe(){
		setHeading("");
		setDescription("");
		setDifficulty("");
		setTime(0);
	}


	public String getHeading() {
		return heading;
	}


	public void setHeading(String heading) {
		this.heading = heading;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Integer getTime() {
		return time;
	}


	public void setTime(Integer time) {
		this.time = time;
	}


	public String getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
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
		String allIngredients = "";
		if(getIngredients() != null){
			for(Ingredient current : getIngredients()){
				allIngredients += " " + current.getInfo();
			}
		}
		else {
			allIngredients = "none";
		}
		
		String allUtensils = "";
		if(getUtensils() != null){
			for(Utensil current : getUtensils()){
				allUtensils += " " + current.getInfo();
			}
		}
		else {
			allUtensils = "none";
		}
		
		return getHeading() + ": " + getDescription() + " , difficulty=" + getDifficulty() +
				" , id=" + getId()+" ,ingredients: " + allIngredients + " ,utensils: " + allUtensils;
	}


	@OneToMany
	public Set<Ingredient> getIngredients() {
		return ingredients;
	}


	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}


	@OneToMany
	public Set<Utensil> getUtensils() {
		return utensils;
	}


	public void setUtensils(Set<Utensil> utensils) {
		this.utensils = utensils;
	}	
}
