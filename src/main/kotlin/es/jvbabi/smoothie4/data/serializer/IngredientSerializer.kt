package es.jvbabi.smoothie4.data.serializer

import es.jvbabi.smoothie4.data.model.Ingredient
import es.jvbabi.smoothie4.data.model.Ingredients
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.*
import org.jetbrains.exposed.dao.id.EntityID

object IngredientSerializer : KSerializer<Ingredient> {
    override val descriptor = buildClassSerialDescriptor("Ingredient") {
        element<Int>("id")
        element<String>("name")
        element<Boolean>("available")
    }

    override fun serialize(encoder: Encoder, value: Ingredient) {
        val json = JsonObject(mapOf(
            "id" to JsonPrimitive(value.id.value),
            "name" to JsonPrimitive(value.name),
            "available" to JsonPrimitive(value.available)
        ))
        encoder.encodeSerializableValue(JsonObject.serializer(), json)
    }

    override fun deserialize(decoder: Decoder): Ingredient {
        val json = decoder.decodeSerializableValue(JsonObject.serializer())
        val id = json["id"]!!.jsonPrimitive.int
        val name = json["name"]!!.jsonPrimitive.content
        val available = json["available"]!!.jsonPrimitive.boolean

        val ingredient = Ingredient(EntityID(id, Ingredients))
        ingredient.apply {
            this.name = name
            this.available = available
        }
        return ingredient
    }
}