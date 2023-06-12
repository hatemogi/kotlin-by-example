# 찾기

`find` 함수는 어떤 컬렉션에 주어진 명제에 참인 있는지 앞에서부터 차례로 찾아봅니다. `findLast` 함수는 마찬가지로 주어진 명제에 참인 요소를 찾는데, 뒤에서부터 순서대로 찾는다는 점이 다릅니다. 두 함수 모두, 조건에 해당하는 요소가 없다면 `null`을 반환합니다.

```kotlin
fun main() {

//sampleStart
    val words = listOf("컬렉션에", "있는", "어떤", "아이템", "골라서", "찾기")           // 1

    val first = words.find { it.startsWith("아이") }                                // 2
    val last = words.findLast { it.startsWith("아이") }                             // 3

    val nothing = words.find { it.contains("없는") }                                // 4
//sampleEnd

    println("\"아이\"로 시작하는 첫번째 단어는 \"$first\"입니다.")
    println("\"아이\"로 시작하는 마지막 단어는 \"$last\"입니다.")
    println("\"없는\"을 포함한 단어는 ${nothing?.let { "\"$it\"" } ?: "null"}입니다.")
}
```

1. 단어들이 들어있는 컬렉션을 준비합니다.
2. "아이"로 시작하는 첫 번째 단어를 찾아봅니다.
3. "아이"로 시작하는 마지막 단어를 찾습니다.
4. "없는"을 담고 있는 첫 번째 단어를 찾습니다.
