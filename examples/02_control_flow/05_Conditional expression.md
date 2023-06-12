# if 조건식

코틀린에는 `조건 ? 참일 때 : 거짓일 때` 3항 연산자가 따로 없습니다. `if`문이 식의 형태로 그 역할을 대신합니다.

```kotlin
fun main() {
//sampleStart
    fun max(a: Int, b: Int) = if (a > b) a else b         // 1

    println(max(99, -42))
//sampleEnd
}
```

1. `if` 문이 식(expression)의 형태로 쓰여서 반환값을 주었습니다.
