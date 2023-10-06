package chapter3

val String.test: Int
    get() = 1

infix fun Any.test(other : Any) = Pair(this,other)

fun main(){
    "gona" test "hi"
}


