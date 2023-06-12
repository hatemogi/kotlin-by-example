# 최소와 최대

`minOrNull`과 `maxOrNull` 함수는, 각각 컬렉션에 있는 최솟값과 최댓값을 찾아줍니다. 만약 컬렉션이 비어있다면, `null`을 반환합니다.

```kotlin
fun main() {

//sampleStart
    val numbers = listOf(1, 2, 3)
    val empty = emptyList<Int>()
    val only = listOf(3)

    println("숫자들: $numbers, 최소 = ${numbers.minOrNull()} 최대 = ${numbers.maxOrNull()}") // 1
    println("빈 리스트: $empty, 최소 = ${empty.minOrNull()}, 최대 = ${empty.maxOrNull()}")   // 2
    println("한개짜리: $only, 최소 = ${only.minOrNull()}, 최대 = ${only.maxOrNull()}")      // 3
//sampleEnd
}
```

1. 뭔가 들어 있는 컬렉션의 경우에는, 최솟값과 최댓값이 반환됩니다.
2. 빈 컬렉션에 대해서는 `null`이 반환됩니다.
3. 딱 한 개의 원소가 들어있는 컬렉션에 대해서는, 두 함수 모두 그 한 값이 반환됩니다.
