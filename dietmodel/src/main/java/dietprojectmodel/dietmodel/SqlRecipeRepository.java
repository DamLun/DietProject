package dietprojectmodel.dietmodel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlRecipeRepository extends RecipeRepository, JpaRepository<Recipe, Long> {

}
