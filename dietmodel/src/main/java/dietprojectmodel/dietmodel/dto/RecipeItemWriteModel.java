package dietprojectmodel.dietmodel.dto;

import dietprojectmodel.dietmodel.Ingredient;
import dietprojectmodel.dietmodel.RecipeItem;

public class RecipeItemWriteModel {
	private Ingredient ingredient;
	private int quantity;
	
	
	public Ingredient getIngredient() {
		return ingredient;
	}
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public RecipeItem toRecipeItem() {
		return new RecipeItem(quantity, ingredient);
	}
}
