# 함수 Functions

## 기본값 파라미터와 이름지정 파라미터

```kotlin
fun printMessage(message: String): Unit {                               // 1
    println(message)
}

fun printMessageWithPrefix(message: String, prefix: String = "Info") {  // 2
    println("[$prefix] $message")
}

fun sum(x: Int, y: Int): Int {                                          // 3
    return x + y
}

fun multiply(x: Int, y: Int) = x * y                                    // 4

fun main() {
    printMessage("Hello")                                               // 5
    printMessageWithPrefix("Hello", "Log")                              // 6
    printMessageWithPrefix("Hello")                                     // 7
    printMessageWithPrefix(prefix = "Log", message = "Hello")           // 8
    println(sum(1, 2))                                                  // 9
    println(multiply(2, 4))                                             // 10
}
```

1. 이 함수는 `String` 타입의 파라미터를 하나 받아서 `Unit`을 반환했습니다. `Unit`은 반환할 **값이 없다**는 의미입니다.
2. 이 함수의 두번째 파라미터는, [기본값 파라미터](https://kotlinlang.org/docs/reference/functions.html#default-arguments)로 `Info`를 받습니다. 함수 반환 타입을 생략했는데, 이러면 `Unit`을 반환한다는 의미입니다.
3. 이 함수는 정수 `Int`를 반환합니다.
4. 이 한줄짜리 함수도 정수를 반환합니다. 반환 타입을 생략했지만, **타입추론**기능 덕분에 정수 타입을 반환한다고 인식합니다.
5. `printMessage` 함수를 `Hello`라는 파라미터를 주고 호출했습니다.
6. `printMessageWithPrefix` 함수를 두 파라미터 모두 전달해서 호출했습니다.
7. 두번째 파라미터를 생략해서 호출하면, 기본값인 `Info`가 전달됩니다.
8. 같은 함수를 [이름지정 파라미터](https://kotlinlang.org/docs/reference/functions.html#named-arguments) 기능을 써서 호출했고, 심지어 파라미터 순서를 바꿨습니다.
9. `sum` 함수 결괏값을 프린트 합니다.
10. `multiply` 함수 결괏값을 프린트 합니다.

## 중위 함수 Infix Functions

파라미터를 하나만 받는 멤버 함수나 확장(extension) 함수는, 해당 함수를 ["중위 함수"](https://kotlinlang.org/docs/reference/functions.html#infix-notation)형태로 쓸 수 있습니다.

```kotlin
fun main() {

  infix fun Int.times(str: String) = str.repeat(this)        // 1
  println(2 times "Bye ")                                    // 2

  val pair = "자바" to "오라클"                                // 3
  println(pair)

  infix fun String.onto(other: String) = Pair(this, other)   // 4
  val myPair = "코틀린" onto "젯브레인스"
  println(myPair)

  val koo = Person("손석구")
  val yeon = Person("장도연")
  koo likes yeon                                             // 5
}

class Person(val name: String) {
  val likedPeople = mutableListOf<Person>()
  infix fun likes(other: Person) { likedPeople.add(other) }  // 6
}
```

1. `Int`에 중위 확장 함수를 정의했습니다.
2. 중위 함수를 호출했습니다.
3. 표준 라이브러리에 있는 중위 함수 `to`를 호출해서 `Pair`를 만들었습니다.
4. 이렇게 `to`랑 같은 일을 하는 `onto`를 직접 구현할 수도 있습니다.
5. 중위 표현법은 멤버 함수나 메서드에도 쓸 수 있습니다.
6. 선언된 클래스 자체가 첫번째 파라미터가 됩니다.

이 예제에서 [지역 함수](https://kotlinlang.org/docs/reference/functions.html#local-functions)(어떤 함수 안에 있는 함수)를 사용한 점도 살펴봐주세요.

### 연산자 함수 Operator Functions

특정 함수들은 [연산자](https://kotlinlang.org/docs/reference/operator-overloading.html)로 "업그레이드"될 수 있고, 해당 연산자를 써서 그 함수를 호출할 수 있습니다.

```kotlin
fun main() {
//sampleStart
  operator fun Int.times(str: String) = str.repeat(this)       // 1
  println(2 * "하이 ")                                          // 2

  operator fun String.get(range: IntRange) = substring(range)  // 3
  val str = "웃어라! 온 세상이 너와 함께 웃을 것이다."
  println(str[0..3])                                           // 4
//sampleEnd
}
```

1. `times`라는 확장 중위 함수에 `operator` 제어자(modifier)를 붙였습니다.
2. `times()`에 대응하는 연산자 기호는 `*`이기 때문에, `2 * "Bye"`의 형태로 해당 함수를 호출할 수 있게 됩니다.
3. 이 연산자 함수로 문자열의 특정 범위에 쉽게 접근할 수 있게 만들었습니다.
4. `get()` 연산자를 써서 [인덱스 접근 문법](https://kotlinlang.org/docs/reference/operator-overloading.html#indexed)을 활용합니다.

### `vararg` 파라미터
[varargs 파라미터](https://kotlinlang.org/docs/reference/functions.html#variable-number-of-arguments-varargs)를 쓰면 쉼표로 연달아 쓴 파라미터들을 전달합니다. 파라미터를 몇 개 받는지 미리 정해두지 않고도, 여러 개를 전달할 수 있게 됩니다.

```kotlin
fun main() {
//sampleStart
    fun printAll(vararg messages: String) {                            // 1
        for (m in messages) println(m)
    }
    printAll("Hello", "Hallo", "Salut", "Hola", "안녕")                 // 2

    fun printAllWithPrefix(vararg messages: String, prefix: String) {  // 3
        for (m in messages) println(prefix + m)
    }
    printAllWithPrefix(
            "Hello", "Hallo", "Salut", "Hola", "안녕",
            prefix = "Greeting: "                                          // 4
    )

    fun log(vararg entries: String) {
        printAll(*entries)                                             // 5
    }
    log("Hello", "Hallo", "Salut", "Hola", "안녕")
//sampleEnd
}
```

1. `vararg` 제어자를 붙여 씁니다.
2. 이렇게 하면 `printAll`에 임의 갯수의 문자열 파라미터를 전할 수 있습니다.
3. 이름지정(named) 파라미터로, vararg에 이어서 같은 타입의 또다른 파라미터를 추가로 전달할 수도 있습니다.
4. 이름지정(named) 파라미터를 써서, `prefix` 값을 vararg에 이어 추가로 전달했습니다.
5. 실행시점에 vararg는 평범한 배열값입니다. 배열을 vararg 파라미터로 전달하려면, `*` 연산자를 써서 `*entries`처럼 전달할 수 있습니다. `*` 연산자 없이 `entries`로 쓰면 `Array<String>`으로 인식됩니다.