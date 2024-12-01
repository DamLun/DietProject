package dietprojectview.newdietview;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dietprojectcontroller.dietcontroller.RecipeImportService;
import dietprojectcontroller.dietcontroller.logic.RecipeService;
import dietprojectmodel.dietmodel.dto.RecipeReadModel;
import dietprojectmodel.dietmodel.dto.RecipeWriteModel;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/recipe")

public class RecipeViewController {
	private final RecipeImportService recipeImportService;
	private final RecipeService recipeService;

	public RecipeViewController(final RecipeImportService recipeImportService, final RecipeService recipeService) {
		this.recipeImportService = recipeImportService;
		this.recipeService = recipeService;
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

	@GetMapping
	String showRecipes() {
		//model.addAttribute("recipe", new RecipeWriteModel());
		return "recipe"; //nazwa pliku .html
	}

	@ResponseBody
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<RecipeWriteModel> createRecipe(@RequestBody RecipeWriteModel recipeToCreate) {
		RecipeReadModel recipe = recipeService.createRecipe(recipeToCreate);
		return ResponseEntity.created(URI.create("/" + recipeToCreate.getId())).body(recipeToCreate);
	}

}
