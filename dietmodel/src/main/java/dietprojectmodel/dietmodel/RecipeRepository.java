package dietprojectmodel.dietmodel;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RecipeRepository{
	
	List<Recipe> findAll();
		
	Optional<Recipe> findById(Long id);
	
	Optional<Recipe> findByName(String name);
	
	Recipe save (Recipe entity);
	
	@Query(value = "select i.ingredient_name, sum(ri.quantity), i.unit"
			+ "from Recipe r "
			+ "join RecipeItem ri on r.id_recipe = ri.id_recipe"
			+ "join Ingredient i on ri.id_ingredient = i.id_ingredient"
			+ "where r.id_recipe in (:ids)"
			+ "group by 1,3", nativeQuery = true)
	public List<ShoppingList> getShoppingList(@Param("ids") List<Long> ids);

}
