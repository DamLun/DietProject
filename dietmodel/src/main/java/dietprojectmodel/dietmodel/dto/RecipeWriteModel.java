package dietprojectmodel.dietmodel.dto;

import java.util.Set;
import java.util.stream.Collectors;

import dietprojectmodel.dietmodel.Recipe;

public class RecipeWriteModel {
	private int id;
	private String recipe_name;
	private Set<RecipeItemWriteModel> items;
	
	public String getRecipe_name() {
		return recipe_name;
	}
	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}
	public Set<RecipeItemWriteModel> getItems() {
		return items;
	}
	public void setItems(Set<RecipeItemWriteModel> items) {
		this.items = items;
	}
	
	public Recipe toRecipe() {
		var result = new Recipe();
		result.setRecipe_name(recipe_name);
		result.setItems(
				items.stream()
				.map(RecipeItemWriteModel::toRecipeItem)
				.collect(Collectors.toSet()));
		return result;
	}
	 	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
