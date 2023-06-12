# 변환해 펼치기, 플랫맵

`flatMap`은 컬렉션에 있는 아이템을 각각 순회 가능한 형태로 변환한 다음, 전체 결과를 하나의 리스트로 합쳐냅니다. 각 아이템을 어떻게 변환할지는 사용자가 직접 정의합니다.

```kotlin
fun main() {

//sampleStart
    val fruitsBag = listOf("사과", "오렌지", "바나나")             // 1
    val clothesBag = listOf("티셔츠", "양말", "청바지")            // 2
    val cart = listOf(fruitsBag, clothesBag)                    // 3
    val mapBag = cart.map { it }                                // 4
    val flatMapBag = cart.flatMap { it }                        // 5
//sampleEnd

    println("장바구니 묶음: $mapBag")
    println("구매한 물품들: $flatMapBag")
}
```

1. 과일을 담은 컬렉션을 정의했습니다.
2. 의류를 담은 컬렉션을 정의했습니다.
3. 두 리스트 `fruitsBag`과 `clothesBag`를 다시 `cart`라는 리스트에 담았습니다.
4. `cart`의 아이템들을 `map`으로 변환했습니다. 두 리스트가 각각 그대로 들어있습니다.
5. 이번에는 `flatMap` 메서드를 썼기 때문에, 두 리스트 전체가 하나로 리스트로 합쳐집니다.