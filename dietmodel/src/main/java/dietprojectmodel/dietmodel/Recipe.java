package dietprojectmodel.dietmodel;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity // This tells Hibernate to make a table out of this class
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_recipe;
	private String recipe_name;
	private Date date_added;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
	private Set<RecipeItem> items;

	public Long getRecipe_id() {
		return id_recipe;
	}

	public void setRecipe_id(Long id_recipe) {
		this.id_recipe = id_recipe;
	}

	public String getRecipe_name() {
		return recipe_name;
	}

	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}

	public Date getDate_added() {
		return date_added;
	}

	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}

}