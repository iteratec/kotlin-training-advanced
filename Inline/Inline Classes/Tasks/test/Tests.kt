import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.Test

class Test {
    @Test
    fun modelCreated() {
        val model = Model(1,2, 3)
        val vault = Vault()

        vault.create(model)
        assertEquals(model, vault.read(1))
    }

    @Test
    fun modelCreatedAndDeleted() {
        val model = Model(1,2, 3)
        val vault = Vault()

        vault.create(model)
        assertEquals(model, vault.read(model.id))

        vault.delete(model.id)
        assertNull(vault.read(model.id))
    }

    @Test
    fun deleteModelByTimestamp() {
        // Define an API method to delete a model by timestamp. Overload the given Api.delete(...) method.
        // For the sake of simplicity: A single model should be deleted by an exact timestamp
    }

    @Test
    fun updateModelByTimestampPrecision() {
        // Delete models based on the timestamp precisions.
        // For this, the model must support different timestamp precisions.
        // Alter the Model class to take timestamps in seconds and millis.

        // Define an update method to alter a models timestamp with either seconds or millis precision.
        // Overload the given Api.update(...) method
    }
}
