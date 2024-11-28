package dietprojectmodel.dietmodel;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="ingredient")
public class Ingredient {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_ingredient;
	private String ingredient_name;
	private String unit;
	
	@OneToMany(mappedBy = "ingredient")
	private Set<RecipeItem> item;
	
	public Long getIngredient_id() {
		return id_ingredient;
	}
	public void setIngredient_id(Long id_ingredient) {
		this.id_ingredient = id_ingredient;
	}
	
	public String getIngredient_name() {
		return ingredient_name;
	}
	public void setIngredient_name(String ingredient_name) {
		this.ingredient_name = ingredient_name;
	}
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
}
