package dietprojectmodel.dietmodel;

public class ShoppingList {
    public String ingredientName;
    public double quantity;
    public String unit;
    
    public ShoppingList(String ingredientName, double quantity, String unit) {
		this.ingredientName = ingredientName;
		this.quantity = quantity;
		this.unit = unit;
	}
    
	public String getIngredientName() {
		return ingredientName;
	}

	public double getQuantity() {
		return quantity;
	}

	public String getUnit() {
		return unit;
	}
	
    
    
}
