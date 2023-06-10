# Null 안전성

`NullPointerException` 예외가 발생하는 상황을 대폭 줄이기 위해, 기본 코틀린의 변수에는 `null`을 지정할 수 없게 되어있습니다. 만약 변수가 null이 될 수도 있게 하려면, 타입의 끝에 `?`표시를 붙여 두어야만 합니다.

```kotlin
fun main() {
//sampleStart
    var neverNull: String = "이 변수는 null이 될 수 없습니다"    // 1

    neverNull = null                                         // 2

    var nullable: String? = "이 변수는 null이 될 수 있습니다"    // 3

    nullable = null                                          // 4

    var inferredNonNull = "컴파일러 타입추론은 null-불가로 봅니다" // 5

    inferredNonNull = null                                   // 6

    fun strLength(notNull: String): Int {                    // 7
        return notNull.length
    }

    strLength(neverNull)                                     // 8
    strLength(nullable)                                      // 9
//sampleEnd
}
```

1. null-불가 문자열 변수를 선언했습니다.
2. null-불가 변수에 `null`을 대입하려고 하면, 컴파일 에러가 납니다.
3. null-가능 문자열 변수를 선언했습니다.
4. null-가능 변수에 `null`을 지정했습니다. 이건 문제 없습니다.
5. 컴파일러가 변수 타입을 추론할 때는 null-불가 타입이라고 가정합니다.
6. 컴파일러가 추론한 타입의 변수에 `null`을 대입하려면, 컴파일 에러가 납니다.
7. null-불가 문자열 파라미터를 받는 함수를 선언했습니다.
8. null이 될 수 없는 `String` 파라미터를 전달해 함수를 호출했습니다. 잘 됩니다.
9. 같은 함수를 `String?` 타입의 파라미터로 호출하려고 하면, 컴파일 에러가 납니다.

## Null을 다루는 방법

물론, 코틀린 프로그램에서 null을 써야할 경우도 있습니다. 자바 코드와 소통해야 할 때나, 값이 없는 경우를 표현하려고 할 때 null을 쓰기도 합니다. 코틀린에는 그럴때 우아하게 대처할 수 있는 기능이 있습니다.

```kotlin
//sampleStart
fun describeString(maybeString: String?): String {              // 1
    if (maybeString != null && maybeString.length > 0) {        // 2
        return "문자열 길이: ${maybeString.length}"
    } else {
        return "빈 문자열이거나 null입니다"                         // 3
    }
}
//sampleEnd

fun main() {
    println(describeString(null))
}
```

1. null-가능 문자열 파라미터를 받아서, 길이를 설명하는 문자열을 반환하는 함수입니다.
2. 주어진 문자열이 `null`이 아니고 빈 문자열도 아니라면, 그 문자열의 길이를 포함한 설명을 반환합니다.
3. 그 외에는, 주어진 문자열이 비었거나 null이라고 알려줍니다.
