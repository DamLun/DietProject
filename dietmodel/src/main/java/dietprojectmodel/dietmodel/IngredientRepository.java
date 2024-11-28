package dietprojectmodel.dietmodel;

import java.util.List;
import java.util.Optional;
//lista tylko używanych metod
public interface IngredientRepository {
	
	List<Ingredient> findAll();
	
	Optional<Ingredient> findById(Long id);
	
	Optional<Ingredient> findByName(String name);
	
	Ingredient save(Ingredient entity);
}
