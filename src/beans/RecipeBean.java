package beans;

import ht.Ingredient;
import ht.Utensil;

import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@ManagedBean(name="RecipeBean")
public class RecipeBean {
	private String heading;
	private String description;
	private String steps;
	private Set<Ingredient> ingredients;
	private Integer time;
	private String difficulty;
	private Set<Utensil> utensils;
	private int id;
	
	public RecipeBean(){
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


	public String getSteps() {
		return steps;
	}


	public void setSteps(String steps) {
		this.steps = steps;
	}	
}
