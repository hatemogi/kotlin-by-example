# 람다 함수 Lambda Functions

[람다 함수](https://kotlinlang.org/docs/reference/lambdas.html)는 곧바로 함수를 만드는 간단한 방법입니다. 타입추론 기능과 암묵적 `it` 변수 덕분에 매우 간결하게 람다 함수를 작성할 수 있습니다.

```kotlin
fun main() {
//sampleStart
    // All examples create a function object that performs upper-casing.
    // So it's a function from String to String

    val upperCase1: (String) -> String = { str: String -> str.uppercase() } // 1

    val upperCase2: (String) -> String = { str -> str.uppercase() }         // 2

    val upperCase3 = { str: String -> str.uppercase() }                     // 3

    // val upperCase4 = { str -> str.uppercase() }                          // 4

    val upperCase5: (String) -> String = { it.uppercase() }                 // 5

    val upperCase6: (String) -> String = String::uppercase                  // 6

    println(upperCase1("hello"))
    println(upperCase2("hello"))
    println(upperCase3("hello"))
    println(upperCase5("hello"))
    println(upperCase6("hello"))
//sampleEnd
}
```

1. 람다 함수 각각의 요소에 모두 타입을 명시했습니다. 람다 본문은 중괄호 안에 작성했고, `(String) -> String` 타입의 변수에 지정했습니다.
2. 람다 안쪽에 타입추론 기능을 활용했습니다. 지정되는 변수의 타입으로 부터 람다의 타입이 추론되었습니다.
3. 람다 바깥으로 타입추론이 이어졌습니다. 람다의 파라미터와 반환 타입으로 부터 변수의 타입이 추론되었습니다.
4. 둘 다 추론을 할 수는 없습니다. 컴파일러가 어떤 타입인지 추론할 방법이 없습니다.
5. 파라미터 한 개를 받는 람다의 경우, 별도로 이름을 주지 않고, 암묵적으로 `it` 변수를 사용할 수 있습니다. `it`의 타입을 추론할 수 있는 경우에 특히 더 유용하게 쓰입니다.
6. 람다가 딱 한 번의 함수 호출로 구성된다면, 함수를 지칭하는 (`::`) 표기법으로 선언할 수 있습니다.