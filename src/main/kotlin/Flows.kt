import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun sendNumbers(): Flow<Int> = flow {
    val primesList = listOf(2, 3, 5, 7, 911, 13, 17, 19, 23, 29)
    primesList.forEach {
        delay(500)
        emit(it)
    }
}

/*------------------------------------OR-------------------------*/
fun sendNum() = listOf(2, 3, 5, 7, 9, 11, 13, 17, 19, 23, 29).asFlow()

/*Flowof*/
fun flowOfNums() = flowOf(2, 3, 5, 7, 9, 11, 13, 17, 19, 23, 29)
fun flowOfStrings() = flowOf("One", "Two", "Three", "Four")

fun main() = runBlocking {
    /*flowOfNums().collect {
        println("Collectng nums : $it")
    }
    flowOfStrings().collect {
        println(it)
    }*/
    flowOfNums().map {
        it + 10
    }.filter {
        it == 12 || it == 13
    }.filterNot {
        it == 13
    }.collect {
        println(it)
    }
}