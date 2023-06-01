# 플랫맵 - 변환해 펼치기 flatMap

`flatMap`은 컬렉션에 있는 요소를 각각 순회 가능한 형태로 변환한 다음, 전체 결과를 하나의 리스트로 합쳐냅니다. 어떻게 변환할 지는 사용자가 직접 정의합니다.

```kotlin
fun main() {

//sampleStart
    val fruitsBag = listOf("apple","orange","banana","grapes")  // 1
    val clothesBag = listOf("shirts","pants","jeans")           // 2
    val cart = listOf(fruitsBag, clothesBag)                    // 3
    val mapBag = cart.map { it }                                // 4
    val flatMapBag = cart.flatMap { it }                        // 5
//sampleEnd

    println("Your bags are: $mapBag")
    println("The things you bought are: $flatMapBag")
}
```

1. 과일 이름들을 담은 컬렉션을 정의했습니다.
2. 옷 종류을 담은 컬렉션을 정의했습니다.
3. 두 리스트 `fruitsBag`과 `clothesBag`를 `cart`라는 리스트에 담았습니다.
4. `cart`의 요소들을 `map`으로 변환했습니다. 두 리스트가 그대로 들어있습니다.
5. 이번에는 `flatMap` 메서드를 썼기 때문에, 두 리스트가 합쳐진 하나의 리스트로 반환됩니다.