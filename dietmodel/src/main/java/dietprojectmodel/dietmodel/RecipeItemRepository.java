package dietprojectmodel.dietmodel;

import java.util.List;
import java.util.Optional;

public interface RecipeItemRepository{
	List<RecipeItem> findAll();
	Optional<RecipeItem> findById(Long id);
	RecipeItem save (RecipeItem entity);
}
