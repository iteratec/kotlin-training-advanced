import kotlinx.coroutines.*

suspend fun loadUserData() {
    delay(1000) // Simulates loading data
    println("User data loaded")
}

suspend fun setupDatabaseConnection() {
    delay(2000) // Simulates setting up a database connection
    println("Database connection established")
}

suspend fun initializeNetworkInterface() {
    delay(1500) // Simulates initializing the network interface
    println("Network interface initialized")
}

fun main() = runBlocking {
    val userJob = launch { loadUserData() }
    val databaseJob = launch { setupDatabaseConnection() }
    val networkJob = launch { initializeNetworkInterface() }

    // Wait for all jobs to complete
    userJob.join()
    databaseJob.join()
    networkJob.join()

    println("System fully initialized")
}
