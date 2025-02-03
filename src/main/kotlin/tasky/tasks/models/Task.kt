package tasky.tasks.models

@kotlinx.serialization.Serializable
data class Task(
    val id: Int,
    val name: String,
    val description: String,
    val priority: Int,
)