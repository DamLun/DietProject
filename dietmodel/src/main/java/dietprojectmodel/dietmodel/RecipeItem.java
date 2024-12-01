package dietprojectmodel.dietmodel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipe_item")
public class RecipeItem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_recipe_item;
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "id_recipe")
	private Recipe recipe;
	
	@ManyToOne
	@JoinColumn(name = "id_ingredient")
	private Ingredient ingredient;
	
	public RecipeItem() {
		// TODO Auto-generated constructor stub
	}
	
	public RecipeItem(int quantity, Ingredient ingredient){
		this.quantity = quantity;
		this.ingredient = ingredient;
	}
	
	public Ingredient getIngredient() {
		return ingredient;
	}
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	public Recipe getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	public Long getId_recipe_item() {
		return id_recipe_item;
	}
	public void setId_recipe_item(Long id_recipe_item) {
		this.id_recipe_item = id_recipe_item;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
