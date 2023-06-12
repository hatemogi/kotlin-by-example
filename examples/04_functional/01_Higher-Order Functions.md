# 고차 함수 Higher-Order Functions

[고차 함수](https://kotlinlang.org/docs/reference/lambdas.html)는 다른 함수를 파라미터로 받거나, 반환값으로 함수를 돌려주는 함수를 말합니다.

## 함수를 파라미터로 받기

```kotlin
fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {  // 1
    return operation(x, y)                                          // 2
}

fun sum(x: Int, y: Int) = x + y                                     // 3

fun main() {
    val sumResult = calculate(4, 5, ::sum)                          // 4
    val mulResult = calculate(4, 5) { a, b -> a * b }               // 5
    println("sumResult $sumResult, mulResult $mulResult")
}
```

1. 고차 함수를 선언했습니다. 정수 파라미터로 `x`와 `y` 두 개와 `operation`이라는 함수를 파라미터로 받았습니다. `operation` 파라미터는 함수 타입입니다.
2. 고차 함수의 결괏값은 `operation` 함수에, 주어진 `x`, `y`를 전달해 호출한 결괏값을 그대로 반환했습니다.
3. `operation` 함수 타입과 일치하는 함수를 하나 선언했습니다.
4. 정수값 두 개와 함수 파라미터 `::sum`을 전달해 호출했습니다. `::`는 어떤 함수를 이름으로 지칭하는 표기법입니다.
5. 람다 함수 문법을 써서 해당 고차 함수에 전달해 호출했습니다. 훨씬 깔끔하죠?

### 함수를 반환하는 함수

```kotlin
fun operation(): (Int) -> Int {                                     // 1
    return ::square
}

fun square(x: Int) = x * x                                          // 2

fun main() {
    val func = operation()                                          // 3
    println(func(2))                                                // 4
}
```

1. 함수를 반환하는 고차 함수를 선언했습니다. `(Int) -> Int`는 `square` 함수의 파라미터 타입과 반환 타입을 나타냅니다.
2. 해당 타입과 일치하는 함수를 선언했습니다.
3. `operation` 함수를 호출한 결괏값을 변수에 대입했습니다. 여기서 `func`는 `operation` 함수에서 반환한 `square` 함수를 가리키게 됩니다.
4. `func` 함수를 호출했습니다. 결과적으로 `square` 함수가 실행됩니다.