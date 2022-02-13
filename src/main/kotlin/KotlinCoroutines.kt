import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main() = runBlocking {
    /*println("Main Thread Started : ${Thread.currentThread().name} ${System.currentTimeMillis()}")

    val t = thread { //creates background thread(Worker Thread)
        println("New Thread Started : ${Thread.currentThread().name} ${System.currentTimeMillis()}")
        Thread.sleep(1000)
        println("New Thread Ended : ${Thread.currentThread().name} ${System.currentTimeMillis()}")
    }

    val g = GlobalScope.launch {
        println("Coroutine Started ${Thread.currentThread().name}") // Thread T1 say
        delay(1000) // coroutine suspends but thread T1 is free (not blocked)
        println("Coroutine Ended ${Thread.currentThread().name}") // May execute in T1 or some other thread
    }

    val job: Job = launch {
        println("Coroutine Start ${Thread.currentThread().name}") // Thread T1 say
        delay(1000) // coroutine suspends but thread T1 is free (not blocked)
        println("Coroutine End ${Thread.currentThread().name}") // May execute in T1 or some other thread
    }

    val jobDeferred: Deferred<Int> = async {
        99
    }
    val num: Int = jobDeferred.await()
    println(num)

    println("Main Thread Ended : ${Thread.currentThread().name} ${System.currentTimeMillis()}")
     job.join()
    job.cancelAndJoin()*/

    //Cooperative Coroutine
    val job: Job = launch(Dispatchers.Default) {
        try {
            for (i in 0..500) {
                if (!isActive)
                    return@launch
                print("$i.")
                delay(1)
                //yield()
            }
        } catch (e: Exception) {
            println("\nException caught")
        } finally {
            println("Finally block executed")
        }
    }
    delay(10)
    job.cancelAndJoin()
//    job.join()
}

