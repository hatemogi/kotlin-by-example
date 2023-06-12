# 둘로 가르기

`partition` 함수는 컬렉션에 있는 아이템을 주어진 명제에 대해 참인 것들과 거짓인 것들로 나누어 한 쌍(Pair)의 리스트로 반환합니다.

 1. 해당 명제에 `true`로 나오는 아이템들
 1. 해당 명제에 `false`로 나오는 아이템들

```kotlin
fun main() {

//sampleStart
    val numbers = listOf(1, -2, 3, -4, 5, -6)                 // 1

    val evenOdd = numbers.partition { it % 2 == 0 }           // 2
    val (positives, negatives) = numbers.partition { it > 0 } // 3
//sampleEnd

    println("숫자들: $numbers")
    println("짝수: ${evenOdd.first}")
    println("홀수: ${evenOdd.second}")
    println("양수: $positives")
    println("음수: $negatives")
}

```

1. 여러 숫자들을 담은 컬렉션을 준비했습니다.
2. `numbers` 안에 있는 숫자들을 짝수와 홀수 리스트로 나눠서 `Pair`에 담았습니다.
3. `numbers`에 있는 숫자를 양수와 음수로 나눈 `Pair`에 두 리스트를 담았고, 그 두 리스트를 다시 구조분해(destructuring)로 두 변수에 나눠 담았습니다.
