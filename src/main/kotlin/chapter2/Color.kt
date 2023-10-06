package chapter2

enum class Color(
    val r : Int,
    val g : Int,
    val b : Int,
) {
    RED(255,0,0),
    GREEN(0,255,0);

    fun total() = r + g + b;
}

fun mix(c1 : Color, c2 : Color){
    when(setOf(c1,c2)){
        setOf(Color.RED,Color.GREEN) -> 1

    }

}