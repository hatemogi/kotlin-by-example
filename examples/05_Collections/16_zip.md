# 지퍼

`zip` 함수는 주어진 두 컬렉션의 각 아이템을 합쳐서 새로운 컬렉션 한 개로 만듭니다. 기본적으로, 결과 컬렉션에는 주어진 두 컬렉션의 각 아이템들을 순서대로 하나씩 취한 `Pair`를 차례로 담습니다. 별도로, 결과 컬렉션을 어떤 구조로 만들어낼지 정의할 수도 있습니다.

결과 컬렉션에는, 주어진 두 컬렉션에 담긴 아이템 개수 중 더 작은 수만큼 담기게 됩니다. 두 컬렉션의 아이템이 같은 개수라면, 결과 컬렉션에도 같은 개수의 아이템이 담기게 됩니다.

```kotlin
fun main() {

//sampleStart
    val A = listOf("a", "b", "c")                  // 1
    val B = listOf(1, 2, 3, 4)                     // 1

    val resultPairs = A zip B                      // 2
    val resultReduce = A.zip(B) { a, b -> "$a$b" } // 3
//sampleEnd

    println("A zip B: $resultPairs")
    println("\$A\$B: $resultReduce")
}
```

1. 컬렉션을 두 개 준비했습니다.
2. 두 컬렉션을 합쳐서 하나의 리스트로 합쳤습니다. 중위 표기법으로 `zip`을 썼습니다.
3. 두 컬렉션을 합치는데, 각 아이템 쌍을 한 문자열로 합치도록 했습니다.
