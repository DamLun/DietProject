package dietprojectcontroller.dietcontroller.logic;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dietprojectmodel.dietmodel.Recipe;
import dietprojectmodel.dietmodel.RecipeRepository;
import dietprojectmodel.dietmodel.dto.RecipeReadModel;
import dietprojectmodel.dietmodel.dto.RecipeWriteModel;

@Service
public class RecipeService {
	private RecipeRepository recipeRepository;
	
	public RecipeService(final RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}
	
	public RecipeReadModel createRecipe(RecipeWriteModel source) {
		Recipe recipe = recipeRepository.save(source.toRecipe());
		return new RecipeReadModel(recipe);
	}
	
	public List<RecipeReadModel> readAll(){
		return recipeRepository.findAll().stream()
				.map(RecipeReadModel::new)
				.collect(Collectors.toList());
	}
}
