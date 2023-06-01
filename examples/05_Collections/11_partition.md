# 분할 partition

`partition` 함수는 컬렉션에 있는 요소들을 주어진 조건에 맞는 요소들과 그렇지 않은 요소들로 나눠 한 쌍(Pair)의 리스트로 반환합니다.

 1. 주어진 조건에 `true`로 나오는 요소들
 1. 주어진 조건에 `false`로 나오는 요소들

```kotlin
fun main() {

//sampleStart
    val numbers = listOf(1, -2, 3, -4, 5, -6)                 // 1

    val evenOdd = numbers.partition { it % 2 == 0 }           // 2
    val (positives, negatives) = numbers.partition { it > 0 } // 3
//sampleEnd

    println("Numbers: $numbers")
    println("Even numbers: ${evenOdd.first}")
    println("Odd numbers: ${evenOdd.second}")
    println("Positive numbers: $positives")
    println("Negative numbers: $negatives")
}

```

1. 여러 숫자들을 담은 컬렉션을 준비했습니다.
2. `numbers` 안에 있는 숫자들을 짝수와 홀수 리스트로 나눠서 `Pair`에 담았습니다.
3. `numbers`에 있는 숫자를 양수와 음수로 나눈 `Pair`에 두 리스트를 담았고, 그 두 리스트를 다시 디스트럭쳐링으로 두 변수에 담았습니다.
