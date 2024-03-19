interface Api {

    fun create(model: Model)

    fun read(id: Long): Model?

    fun update(id: Long, value: Long): Model?

    fun delete(id: Long): Model?

}
