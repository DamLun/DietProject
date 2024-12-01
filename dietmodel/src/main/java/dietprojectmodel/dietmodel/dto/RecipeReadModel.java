package dietprojectmodel.dietmodel.dto;

import java.util.Set;
import java.util.stream.Collectors;

import dietprojectmodel.dietmodel.Recipe;

public class RecipeReadModel {
	private String recipe_name;
	private Set<RecipeItemReadModel> items;
	
	public RecipeReadModel(Recipe source) {
		recipe_name = source.getRecipe_name();
		items = source.getItems().stream().map(RecipeItemReadModel::new).collect(Collectors.toSet());
	}
	
	public String getRecipe_name() {
		return recipe_name;
	}
	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}
	public Set<RecipeItemReadModel> getItems() {
		return items;
	}
	public void setItems(Set<RecipeItemReadModel> items) {
		this.items = items;
	}
}
