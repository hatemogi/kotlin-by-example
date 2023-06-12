# 몇 개 있나

`count` 함수는 컬렉션에 몇 개의 아이템이 들어있는지 반환합니다. 참 또는 거짓을 판단하는 함수를 전달하면 해당하는 아이템이 몇 개 있는지 확인해 줍니다.

```kotlin
fun main() {

//sampleStart
    val numbers = listOf(1, -2, 3, -4, 5, -6)            // 1

    val totalCount = numbers.count()                     // 2
    val evenCount = numbers.count { it % 2 == 0 }        // 3
//sampleEnd

    println("전체 아이템 갯수: $totalCount")
    println("짝수 갯수: $evenCount")
}
```

1. 여러 숫자를 담은 컬렉션을 만들었습니다.
2. 전체 갯수를 구합니다.
3. 짝수가 몇 개 있는지 확인합니다.
