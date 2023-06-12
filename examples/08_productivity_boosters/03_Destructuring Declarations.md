# 구조분해 Destructuring

[구조분해](https://kotlinlang.org/docs/reference/multi-declarations.html#destructuring-declarations) 문법을 사용하면, 인스턴스의 멤버들에 접근할 때 아주 편리합니다. 인스턴스 이름을 생략하고도 원하는 속성을 쓸 수 있어서 여러 줄의 코드가 절약되기도 합니다.

```kotlin
fun findMinMax(list: List<Int>): Pair<Int, Int> {
    // do the math
    return Pair(50, 100)
}

fun main() {
//sampleStart
    val (x, y, z) = arrayOf(5, 10, 15)                              // 1

    val map = mapOf("손석구" to 40, "장도연" to 38)
    for ((name, age) in map) {                                      // 2
        println("${name}님은 올해 ${age}세입니다.")
    }

    val (min, max) = findMinMax(listOf(100, 90, 50, 98, 76, 83))    // 3

//sampleEnd
}
```

1. `Array`를 구조분해 했습니다. 왼쪽의 변수 갯수가, 우측의 값 갯수와 일치합니다.
2. 맵도 구조분해할 수 있습니다. `name`과 `age` 변수가 맵의 각 키-값 쌍에 대응됩니다.
3. 기본 자료 구조인 `Pair`와 `Triple` 타입에 대해서도 구조분해 문법을 쓸 수 있습니다.

```kotlin
data class User(val username: String, val email: String)    // 1

fun getUser() = User("Mary", "mary@somewhere.com")

fun main() {
    val user = getUser()
    val (username, email) = user                            // 2
    println(username == user.component1())                  // 3

    val (_, emailAddress) = getUser()                       // 4

}
```

1. 데이터 클래스를 선언했습니다.
2. 데이터 클래스 인스턴스를 구조분해 했습니다. 인스턴스 필드의 값들을 가져왔습니다.
3. 데이터 클래스는 `component1()`나 `component1()` 같은 구조분해에 필요한 메서드들 자동으로 만들어줍니다.
4. 구조분해후 사용하지 않는 값은, 밑줄(`_`)로 표시해서 컴파일러에게 사용하지 않고 무시한다고 알려줄 수 있습니다.

```kotlin
class Pair<K, V>(val first: K, val second: V) {  // 1
    operator fun component1(): K {
        return first
    }

    operator fun component2(): V {
        return second
    }
}

fun main() {
    val (num, name) = Pair(1, "one")             // 2

    println("num = $num, name = $name")
}
```

1. `Pair` 클래스를 `component1()`와 `component2()` 메서드를 써서 직접 정의해봤습니다.
2. 기본으로 있는 `Pair`와 똑같은 방식으로 구조분해할 수 있습니다.
