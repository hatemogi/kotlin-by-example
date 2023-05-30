# 몇 개 있나 count

`count` 함수는 컬렉션에 몇 개의 요소가 들어있는지 반환합니다. 조건을 판단하는 함수를 전달하면 해당 조건에 맞는 요소가 몇 개 있는 지 확인해 줍니다.

```kotlin
fun main() {

//sampleStart
    val numbers = listOf(1, -2, 3, -4, 5, -6)            // 1

    val totalCount = numbers.count()                     // 2
    val evenCount = numbers.count { it % 2 == 0 }        // 3
//sampleEnd

    println("Total number of elements: $totalCount")
    println("Number of even elements: $evenCount")
}
```

1. 여러 숫자를 담은 컬렉션을 만들었습니다.
2. 전체 갯수를 구합니다.
3. 짝수가 몇 개 있는지 확인합니다.
