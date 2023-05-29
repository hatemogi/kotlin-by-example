# When

코틀린에서는, 흔히 쓰이는 `switch` 구문 대신에, 더 유연하고 명확한 `when` 문법을 씁니다. 명령문(statement) 방식이나, 표현식(expression) 형태로 쓸 수 있습니다.

## When 명령문

```kotlin
fun main() {
    cases("Hello")
    cases(1)
    cases(0L)
    cases(MyClass())
    cases("hello")
}

fun cases(obj: Any) {
    when (obj) {                                     // 1
        1 -> println("One")                          // 2
        "Hello" -> println("Greeting")               // 3
        is Long -> println("Long")                   // 4
        !is String -> println("Not a string")        // 5
        else -> println("Unknown")                   // 6
    }
}

class MyClass
```

1. 이건 `when` 명령문(statement)입니다.
2. `obj`가 `1`이랑 같은지 확인합니다.
3. `obj`가 `"Hello"`와 같은지 확인합니다.
4. 타입 검사를 합니다.
5. 특정 타입이 아닌지 검사합니다.
6. 기본(디폴트) 명령문인데 생략할 수도 있습니다.

특정 조건이 만족될 때까지 차례로 모든 조건을 검사하게 됩니다. 즉, 처음으로 만족된 조건에 따른 명령만 수행하게 됩니다.

## When 표현식

```kotlin
fun main() {
    println(whenAssign("Hello"))
    println(whenAssign(3.4))
    println(whenAssign(1))
    println(whenAssign(MyClass()))
}

fun whenAssign(obj: Any): Any {
    val result = when (obj) {                   // 1
        1 -> "one"                              // 2
        "Hello" -> 1                            // 3
        is Long -> false                        // 4
        else -> 42                              // 5
    }
    return result
}

class MyClass
```


1. 이것이 `when` 식입니다.
2. `obj` 값이 `1`과 같다면 `"one"`라고 지정합니다.
3. `obj` 값이 `"Hello"`와 같다면 `1`로 지정합니다.
4. `obj`가 `Long`타입의 값이라면 `false`로 지정합니다.
5. 위의 모든 조건들이 모두 어긋났다면 `42`로 지정합니다. `when` 명령문에서와는 달리, `when` 식에서는 보통 기본 조건 (else)식이 필요합니다. `when` 식에서는 가능한 모든 경우를 다 처리해야만 하기 때문입니다.