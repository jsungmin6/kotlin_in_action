package chapter3

val String.test: Int
    get() = 1

fun main(){
    println("a".test);
}

