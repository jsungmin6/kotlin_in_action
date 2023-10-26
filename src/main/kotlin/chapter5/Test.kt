package chapter3





fun main(){

    class Person(val age: Int,val name: String)

    val peoples = listOf(Person(29,"tem"),Person(30, "chess"))

    peoples.maxBy({ p: Person -> p.age})
    peoples.maxBy() {p: Person -> p.age } // 함수 호출시 맨 뒤에 있는 인자가 람다 식이면 그 람다를 밖으로 빼낼 수 있다.
    peoples.maxBy{p: Person -> p.age }
    peoples.maxBy{p -> p.age} //문맥에 따라 타입추론 가능해서 생략
    peoples.maxBy { it.age } //it는 람다 파라미터 이름(위에서 p)을 의미

    peoples.joinToString(" ", transform = { p: Person -> p.name })
    peoples.joinToString(" "){ p: Person -> p.name }

    /**
     * 변수 포획
     */
    //람다에서 로컬변수 사용
    //자바와 차이점은 파이널이 아닌 변수에 접근할 수 있다는 점
    //그 변수를 변경도 가능
    //람다 안에서 사용하는 외부 변수를 람다가 포획한 변수라고 부른다. (capture)
    fun printMessagesWithPrefix(messages : Collection<String>, prefix : String){
        messages.forEach{
            println("$prefix $it")
        }
    }

    //컬렉션 함수형 API
    val list = listOf(1,2,3,4)
    list.filter { it%2 == 0 }
    list.map { i -> i*i }.toList()

    //lazy 컬렉션 계산
    //컬렉션 함수는 결과 컬렉션을 즉시 생성한다 .
    //시퀀스를 사용하면 중간 임시 컬렉션을 사용하지 않고도 컬렉션 연산을 연쇄 가능하다
    //큰 컬렉션에 대해서 연산을 연쇄시킬 때는 시퀀스를 사용하는 것을 규칙으로 삼아라

    peoples.asSequence()
        .map(Person::name)
        .filter { it.startsWith("A") }
        .toList()

    //수신 객체 지정 람다
    //with
    //- 객체의 이름을 반복하지 않고도 그 객체에 대해 다양한 연산을 할 수 있다.

    fun withAlphabet() : String {
        val stringBuilder = StringBuilder()
        return with(stringBuilder) {
            for(letter in 'a'..'z'){
                this.append(letter)
            }
            this.toString()
        }
    }

    //apply
    //람다의 결과 대신 수신객체가 필요할 경우
    //객체의 인스턴스를 만들면서 즉시 프로퍼티 중 일부를 초기화 해야하는 경우 유용함

    fun applyAlphabet() = StringBuilder().apply {
        for (letter in 'a'..'z') {
            append(letter)
        }
        append("hi")
    }.toString()

}







