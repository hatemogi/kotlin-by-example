# 정렬

컬렉션의 `sorted` 메서드는 전체 아이템을 오름차순으로 정렬합니다. `sortedBy` 메서드는 각 요소들에 대해 어떤 기준으로 정렬할지 정하는 함수를 파라미터로 받아서 오름차순으로 정렬한 리스트를 반환합니다.

```kotlin
import kotlin.math.abs

fun main() {

//sampleStart
    val shuffled = listOf(5, 4, 2, 1, 3, -10)                   // 1
    val natural = shuffled.sorted()                             // 2
    val inverted = shuffled.sortedBy { -it }                    // 3
    val descending = shuffled.sortedDescending()                // 4
    val descendingBy = shuffled.sortedByDescending { abs(it)  } // 5
//sampleEnd

    println("무작위순: $shuffled")
    println("오름차순: $natural")
    println("오른차순 역순: $inverted")
    println("내림차순: $descending")
    println("절댓값의 내림차순: $descendingBy")
}
```

1. 마구 섞인 숫자들을 담은 컬렉션을 준비했습니다.
2. 숫자들을 차례로 정렬했습니다.
3. `-it`를 기준 함수로 전달해서, 전체 숫자들을 역순으로 정렬했습니다.
4. `sortedDescending` 메서드를 써서 내림차순으로 정렬했습니다.
5. `abs(it)`를 기준 함수로 쓰고, 역순으로 정렬했습니다.
