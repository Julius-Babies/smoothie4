package es.jvbabi.smoothie4.data.repository.implementation

import es.jvbabi.smoothie4.data.model.Ingredient
import es.jvbabi.smoothie4.data.model.Ingredients
import es.jvbabi.smoothie4.data.repository.IngredientRepository
import org.jetbrains.exposed.sql.update

class IngredientRepositoryImpl : IngredientRepository {
    override suspend fun getIngredients(): List<Ingredient> {
        return Ingredient.all().toList()
    }

    override suspend fun getIngredientById(ingredientId: Int): Ingredient? {
        return Ingredient.findById(ingredientId)
    }

    override suspend fun setAvailability(ingredientId: Int, isAvailable: Boolean) {
        Ingredients.update({Ingredients.id eq ingredientId}) {
            it[available] = isAvailable
        }
    }
}