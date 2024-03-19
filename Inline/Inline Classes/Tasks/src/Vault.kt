class Vault : Api {

    private val vault: MutableMap<Long, Model> = mutableMapOf()

    override fun create(model: Model) {
        vault[model.id] = model
    }

    override fun read(id: Long): Model? = vault[id]

    override fun update(id: Long, value: Long): Model? = vault[id]?.copy(value=value)

    override fun delete(id: Long): Model? = vault.remove(id)
}
