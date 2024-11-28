package dietprojectmodel.dietmodel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlIngredientRepository extends IngredientRepository, JpaRepository<Ingredient, Long>{
	//Dodane żeby zawezic zbior metod tylko do tych koniecznych 
}
