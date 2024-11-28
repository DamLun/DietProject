package dietprojectmodel.dietmodel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlRecipeItemRepository extends RecipeItemRepository, JpaRepository<RecipeItem, Long>{

}
