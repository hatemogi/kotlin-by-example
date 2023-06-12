# 변환

`map` 확장함수로 컬렉션에 있는 각 아이템을 모두 변환할 수 있습니다. 각 아이템을 변환하는 함수를 파라미터로 전달합니다.

```kotlin
fun main() {

//sampleStart
    val numbers = listOf(1, -2, 3, -4, 5, -6)     // 1

    val doubled = numbers.map { x -> x * 2 }      // 2

    val tripled = numbers.map { it * 3 }          // 3
//sampleEnd

    println("숫자들: $numbers")
    println("두 배한 숫자들: $doubled")
    println("세 배한 숫자들: $tripled")
}
```

1. 숫자들을 담고 있는 컬렉션을 만듭니다.
2. 숫자들을 두 배로 만듭니다.
3. `it` 표기법을 써서 세 배로 만들었습니다.
