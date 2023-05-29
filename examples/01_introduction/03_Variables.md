# 변수 Variables

코틀린에는 강력한 타입추론(type inference)기능이 있습니다. 변수의 타입을 명시적으로 선언할 수도 있지만, 컴파일러에게 추론하도록 할 때가 많습니다. 코틀린은 불변성(immutability)을 강제하지는 않지만, 권장합니다. 기본적으로 `var` 대신 `val`을 쓰면 좋습니다.

```kotlin
fun main() {
//sampleStart
    var a: String = "initial"  // 1
    println(a)
    val b: Int = 1             // 2
    val c = 3                  // 3
//sampleEnd
}
```

1. 변이(mutable) 변수를 선언하면서 초기화했습니다.
2. 불변(immutable) 변수를 선언하고 초기화했습니다.
3. 불변 변수를 선언하고 초기화했지만, 타입을 명시하지는 않았습니다. 컴파일러가 `Int` 타입이라고 추론합니다.

```kotlin
fun main() {
//sampleStart
    var e: Int  // 1
    println(e)  // 2
//sampleEnd
}
```
{validate="false"}

1. 초기화 없이 변수를 선언했습니다.
2. 초기화하지 않은 변수를 읽으려하면 컴파일러가 `Variable 'e' must be initialized`라고 에러를 발생시킵니다.

언제 변수를 초기화할 지는 자유롭게 정할 수 있습니다만, 처음 읽기 전에는 반드시 초기화해야 합니다.

```kotlin
fun someCondition() = true

fun main() {
//sampleStart
    val d: Int  // 1

    if (someCondition()) {
        d = 1   // 2
    } else {
        d = 2   // 2
    }

    println(d) // 3
//sampleEnd
}
```

1. 변수를 선언했지만, 초기화하지 않았습니다.
2. 조건에 따라 다른 값으로 초기화 했습니다.
3. 변수를 초기화했기 때문에 이제는 읽을 수 있습니다.