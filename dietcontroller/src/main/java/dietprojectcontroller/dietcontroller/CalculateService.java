package dietprojectcontroller.dietcontroller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import dietprojectmodel.dietmodel.RecipeRepository;
import dietprojectmodel.dietmodel.ShoppingList;

@Service
public class CalculateService {
	private final RecipeRepository recipeRepository;

	public CalculateService(final RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	public void calculateShoppingList(List<Long> idsRecipe) {
		List<ShoppingList> shoppingListData = recipeRepository.getShoppingList(idsRecipe);
		if (!shoppingListData.isEmpty()) {
			createShoppingListCsv(shoppingListData);
		}else {
			throw new IllegalStateException("Shopping list is empty");
		}
	}

	private void createShoppingListCsv(List<ShoppingList> shoppingList) {
		String csvPath = "C:\\Users\\damian.lunkiewicz\\Desktop\\";
		try (FileWriter writer = new FileWriter(csvPath)){
			// Nagłowki
			writer.append("Nazwa składnika;Ilość;Jednostka\n");
			// Zapis danych
			for (ShoppingList item : shoppingList) {
				writer.append(item.getIngredientName() + ";" + item.getQuantity() + ";" + item.getUnit() + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File not be generated");
		}
	}
}
