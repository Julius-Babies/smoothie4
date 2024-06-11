package es.jvbabi.smoothie4.data.repository

import es.jvbabi.smoothie4.data.model.Ingredient
import es.jvbabi.smoothie4.data.repository.implementation.IngredientRepositoryImpl

interface IngredientRepository {
    suspend fun getIngredients(): List<Ingredient>
    suspend fun getIngredientById(ingredientId: Int): Ingredient?
    suspend fun setAvailability(ingredientId: Int, isAvailable: Boolean)
}

val ingredientRepository: IngredientRepository = IngredientRepositoryImpl()