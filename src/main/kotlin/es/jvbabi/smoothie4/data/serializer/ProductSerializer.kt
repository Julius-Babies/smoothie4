package es.jvbabi.smoothie4.data.serializer

import es.jvbabi.smoothie4.data.model.Ingredient
import es.jvbabi.smoothie4.data.model.Product
import es.jvbabi.smoothie4.data.model.Products
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.*
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.SizedCollection

object ProductSerializer : KSerializer<Product> {
    override val descriptor = buildClassSerialDescriptor("Product") {
        element<Int>("id")
        element<String>("name")
        element<List<Ingredient>>("ingredients")
    }

    override fun serialize(encoder: Encoder, value: Product) {
        val ingredientsJson = JsonArray(value.ingredients.map { ingredient ->
            JsonObject(mapOf(
                "id" to JsonPrimitive(ingredient.id.value),
                "name" to JsonPrimitive(ingredient.name),
                "available" to JsonPrimitive(ingredient.available)
            ))
        })
        val json = JsonObject(
            mapOf(
                "id" to JsonPrimitive(value.id.value),
                "name" to JsonPrimitive(value.name),
                "ingredients" to ingredientsJson
            )
        )
        encoder.encodeSerializableValue(JsonObject.serializer(), json)
    }

    override fun deserialize(decoder: Decoder): Product {
        val json = decoder.decodeSerializableValue(JsonObject.serializer())
        val id = json["id"]!!.jsonPrimitive.int
        val name = json["name"]!!.jsonPrimitive.content
        val price = json["price"]!!.jsonPrimitive.int
        val ingredientsJson = json["ingredients"]!!.jsonArray
        val ingredients = ingredientsJson.map { ingredientJson ->
            val ingredientId = ingredientJson.jsonObject["id"]!!.jsonPrimitive.int
            Ingredient.findById(ingredientId)!!
        }

        val product = Product(EntityID(id, Products))
        product.apply {
            this.name = name
            this.price = price
            this.ingredients = SizedCollection(ingredients)
        }
        return product
    }
}