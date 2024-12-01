package dietprojectmodel.dietmodel.dto;

import dietprojectmodel.dietmodel.Ingredient;
import dietprojectmodel.dietmodel.RecipeItem;

public class RecipeItemReadModel {
	private String ingredientName;
	private int quantity;
	private String unit;
	
	public RecipeItemReadModel(RecipeItem source) {
		this.ingredientName = source.getIngredient().getIngredient_name();
		this.quantity = source.getQuantity();
		this.unit = source.getIngredient().getUnit();
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getIngredientName() {
		return ingredientName;
	}
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
}
