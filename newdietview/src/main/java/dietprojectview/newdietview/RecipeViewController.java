package dietprojectview.newdietview;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import dietprojectcontroller.dietcontroller.RecipeImportService;

import org.springframework.mock.web.MockMultipartFile;


@RestController
@RequestMapping(path = "/")
public class RecipeViewController {
	// private final RecipeImportService recipeImportService;

	private final RecipeImportService recipeImportService;
	
	public RecipeViewController(final RecipeImportService recipeImportService) {
		this.recipeImportService = recipeImportService;
	}

	@GetMapping(path = "/import")
	public void importRecipe() {
		try {
			System.out.println("0");
			final String fileName = "P:/PRZEPISY.csv";
			File file = new File(fileName);
			FileInputStream input = new FileInputStream(file);
			MultipartFile multipartFile = new MockMultipartFile("PRZEPISY.csv", file.getName(), "text/csv",
					IOUtils.toByteArray(input));
			recipeImportService.importRecipeWithIngredientsFromCsv(multipartFile);
			System.out.println("Plik zaimportowano poprawnie.");
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return;
	}

	//@GetMapping(path = "/showAll")
	//public @ResponseBody List<Object> getAllRecipeWithIngredients() {
		//return recipeImportService.getAllRecipeWithIngredients();
	//}
}
