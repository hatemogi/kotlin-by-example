# 찾기 find, findLast

`find` 함수는 어떤 컬렉션에 특정 조건에 맞는 요소가 있는지 앞에서부터 찾아봅니다. `findLast` 함수는 어떤 컬렉션에 특정 조건에 맞는 요소가 있는지 뒤에서부터 찾아봅니다. 두 함수 모두, 조건에 해당하는 요소가 없다면 `null`을 반환합니다.

```kotlin
fun main() {

//sampleStart
    val words = listOf("Lets", "find", "something", "in", "collection", "somehow")  // 1

    val first = words.find { it.startsWith("some") }                                // 2
    val last = words.findLast { it.startsWith("some") }                             // 3

    val nothing = words.find { it.contains("nothing") }                             // 4
//sampleEnd

    println("The first word starting with \"some\" is \"$first\"")
    println("The last word starting with \"some\" is \"$last\"")
    println("The first word containing \"nothing\" is ${nothing?.let { "\"$it\"" } ?: "null"}")
}
```

1. 단어들이 들어있는 컬렉션을 준비합니다.
2. "some"으로 시작하는 첫번째 단어를 찾아봅니다.
3. "some"으로 시작하는 마지막 단어를 찾습니다.
4. "nothing"을 담고 있는 첫번째 단어를 찾습니다.
