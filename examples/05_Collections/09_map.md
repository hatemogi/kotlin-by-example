# 변환 map

*map* 확장함수로 컬렉션에 있는 모든 요소들을 변환할 수 있습니다. 각 요소를 변환하는 함수를 파라미터로 전달합니다.

```kotlin
fun main() {

//sampleStart
    val numbers = listOf(1, -2, 3, -4, 5, -6)     // 1

    val doubled = numbers.map { x -> x * 2 }      // 2

    val tripled = numbers.map { it * 3 }          // 3
//sampleEnd

    println("Numbers: $numbers")
    println("Doubled Numbers: $doubled")
    println("Tripled Numbers: $tripled")
}
```

1. 숫자들을 담고 있는 컬렉션을 만듭니다.
2. 숫자들을 두 배로 만듭니다.
3. `it` 표기법을 써서 3배로 만들었습니다.
