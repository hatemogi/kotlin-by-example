# 최소와 최대 minOrNull, maxOrNull

`minOrNull`과 `maxOrNull` 함수는, 각각 컬렉션에 있는 최소값과 최대값을 찾아줍니다. 만약 컬렉션이 비어있다면, `null`을 반환합니다.

```kotlin
fun main() {

//sampleStart
    val numbers = listOf(1, 2, 3)
    val empty = emptyList<Int>()
    val only = listOf(3)

    println("Numbers: $numbers, min = ${numbers.minOrNull()} max = ${numbers.maxOrNull()}") // 1
    println("Empty: $empty, min = ${empty.minOrNull()}, max = ${empty.maxOrNull()}")        // 2
    println("Only: $only, min = ${only.minOrNull()}, max = ${only.maxOrNull()}")            // 3
//sampleEnd
}
```

1. 뭔가 들어 있는 컬렉션의 경우에는, 최소값과 최대값이 반환됩니다.
2. 빈 컬렉션에 대해서는 `null`이 반환됩니다.
3. 딱 한 개의 원소가 들어있는 컬렉션에 대해서는, 두 함수 모두 그 값이 반환됩니다.
