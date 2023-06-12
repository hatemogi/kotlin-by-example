# 필터 filter

`filter` 함수로 컬렉션의 요소들을 선별할 수 있습니다. 원하는 조건을 판단하기 위해 함수 파라미터를 받습니다. 각각의 요소에 대해 주어진 함수를 적용해 `true`가 나오는 요소들만 모은 새 컬렉션을 반환합니다.

```kotlin
fun main() {

//sampleStart
    val numbers = listOf(1, -2, 3, -4, 5, -6)      // 1

    val positives = numbers.filter { x -> x > 0 }  // 2

    val negatives = numbers.filter { it < 0 }      // 3
//sampleEnd

    println("Numbers: $numbers")
    println("Positive Numbers: $positives")
    println("Negative Numbers: $negatives")
}
```

1. 숫자를 담고 있는 컬렉션을 만들었습니다.
2. 양수만 취합니다.
3. `it` 표기법을 써서 음수만 취했습니다.
