package dietprojectcontroller.dietcontroller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import dietprojectmodel.dietmodel.Ingredient;
import dietprojectmodel.dietmodel.IngredientRepository;
import dietprojectmodel.dietmodel.Recipe;
import dietprojectmodel.dietmodel.RecipeItem;
import dietprojectmodel.dietmodel.RecipeItemRepository;
import dietprojectmodel.dietmodel.RecipeRepository;

@RequestScope
public class RecipeImportService {

	private final RecipeRepository recipeRepository;
	private final IngredientRepository ingredientRepository;
	private final RecipeItemRepository recipeItemRepository;

	public RecipeImportService(RecipeRepository recipeRepository, IngredientRepository ingredientRepository,
			RecipeItemRepository recipeItemRepository) {
		this.recipeRepository = recipeRepository;
		this.ingredientRepository = ingredientRepository;
		this.recipeItemRepository = recipeItemRepository;
	}

	public void importRecipeWithIngredientsFromCsv(MultipartFile file) throws IOException {
		try (InputStreamReader isr = new InputStreamReader(file.getInputStream())) {
			CSVParser csvParser = new CSVParser(isr,
					CSVFormat.DEFAULT.withHeader().withIgnoreHeaderCase().withTrim().withDelimiter(';'));
			for (CSVRecord csvRecord : csvParser) {
				String recipeName = csvRecord.get(0);
				String ingredientName = csvRecord.get(1);
				String quantity = csvRecord.get(2);
				String unit = csvRecord.get(3);
				Recipe recipe = recipeRepository.findByName(recipeName).orElse(null);
				Ingredient ingredient = ingredientRepository.findByName(ingredientName).orElse(null);

				if (recipe == null) {
					recipe = new Recipe();
					recipe.setRecipe_name(recipeName);
					recipe.setDate_added(Date.valueOf(LocalDate.now()));
					recipe = recipeRepository.save(recipe);
				}

				if (ingredient == null) {
					ingredient = new Ingredient();
					ingredient.setIngredient_name(ingredientName);
					ingredient.setUnit(unit);
					ingredient = ingredientRepository.save(ingredient);
				}
				if (recipe != null && ingredient != null) {
					RecipeItem recipeItem = new RecipeItem();
					recipeItem.setRecipe(recipe);
					recipeItem.setIngredient(ingredient);
					int qty = Integer.parseInt(quantity);
					recipeItem.setQuantity(qty);
					recipeItemRepository.save(recipeItem);
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
