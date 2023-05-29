# 널 안전성 Null Safety

`NullPointerException` 세상에서 벗어나기 위해, 기본적으로 코틀린의 변수에는 `null`을 지정할 수 없게 되어있습니다. 만약 변수가 null이 될 수도 있다면, 타입의 끝에 `?`표시를 붙여 두어야만 합니다.

```kotlin
fun main() {
//sampleStart
    var neverNull: String = "This can't be null"            // 1

    neverNull = null                                        // 2

    var nullable: String? = "You can keep a null here"      // 3

    nullable = null                                         // 4

    var inferredNonNull = "The compiler assumes non-null"   // 5

    inferredNonNull = null                                  // 6

    fun strLength(notNull: String): Int {                   // 7
        return notNull.length
    }

    strLength(neverNull)                                    // 8
    strLength(nullable)                                     // 9
//sampleEnd
}
```
{validate="false"}

1. `null`-불가 문자열 변수를 선언했습니다.
2. `null`-불가 변수에 `null`을 대입하려고 하면, 컴파일 에러가 발생합니다.
3. `null`-가능 문자열 변수를 선언했습니다.
4. `null`-가능 변수에 `null` 값을 지정했습니다. 이건 문제 없습니다.
5. 컴파일러가 초기화 값으로 변수 타입을 추론할 때는 `null`-불가 타입이라고 가정합니다.
6. 컴파일러가 추론한 타입의 변수에 `null`을 대입하려면, 컴파일 에러가 발생합니다.
7. `null`-불가 문자열 파라미터를 받는 함수를 선언했습니다.
8. null이 될 수 없는 `String` 파라미터를 전달해 함수를 호출했습니다. 잘 됩니다.
9. 같은 함수를 `String?` 타입의 파라미터로 호출하려고 하면, 컴파일 에러가 발생합니다.

## Working with Nulls

Sometimes Kotlin programs need to work with null values, such as when interacting with external Java code or
representing a truly absent state. Kotlin provides null tracking to elegantly deal with such situations.

코틀린 프로그램에서 null 값을 써야할 경우도 있습니다. 자바 코드와 소통해야 할 때나, 정말 없는 값을 표현하고자 할 때 null 값을 쓰기도 합니다. 코틀린에는 그런 상황을 우아하게 대처할 수 있는 기능이 있습니다.

```kotlin
//sampleStart
fun describeString(maybeString: String?): String {              // 1
    if (maybeString != null && maybeString.length > 0) {        // 2
        return "String of length ${maybeString.length}"
    } else {
        return "Empty or null string"                           // 3
    }
}
//sampleEnd

fun main() {
    println(describeString(null))
}
```

1. null-가능 문자열 파라미터를 받아서 설명하는 문자열을 반환하는 함수입니다.
2. 주어진 문자열이 `null`이 아니고 빈 문자열도 아니라면, 그 문자열의 길이를 포함한 설명을 반환합니다.
3. 그 외에는, 해당 문자열이 비었거나 null이라고 알려줍니다.
