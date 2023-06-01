# 정렬 sorted

컬렉션의 `sorted` 메서드는 전체 요소를 오름차순으로 정렬한 리스트를 반환합니다.

`sortedBy` 메서드는 각 요소들에 대해 어떤 기준으로 정렬할 지 정하는 함수를 받아서 오름차순으로 정렬한 리스트를 반환합니다.

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

    println("Shuffled: $shuffled")
    println("Natural order: $natural")
    println("Inverted natural order: $inverted")
    println("Inverted natural order value: $descending")
    println("Inverted natural order of absolute values: $descendingBy")
}
```

1. 마구 섞인 숫자들을 담은 컬렉션을 준비했습니다.
2. 숫자들을 차례로 정렬했습니다.
3. `-it`를 기준 함수로 전달해서, 전체 숫자들을 역순으로 정렬했습니다.
4. `sortedDescending` 메서드를 써서 내림차순으로 정렬했습니다.
5. `abs(it)`를 기준 함수로 쓰고, 역순으로 정렬했습니다.
