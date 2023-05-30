# 있나 없나 any, all, none

이하, 컬렉션에 어떤 요소가 있는지 없는지 확인하는 함수들입니다.

### 하나라도 있나? `any`

`any` 함수는 컬렉션에 특정 요소가 하나라도 있으면 `true`를 반환합니다.

```kotlin
fun main() {

//sampleStart
    val numbers = listOf(1, -2, 3, -4, 5, -6)            // 1

    val anyNegative = numbers.any { it < 0 }             // 2

    val anyGT6 = numbers.any { it > 6 }                  // 3
//sampleEnd

    println("Numbers: $numbers")
    println("Is there any number less than 0: $anyNegative")
    println("Is there any number greater than 6: $anyGT6")
}
```

1. 숫자들을 담고 있는 컬렉션을 준비했습니다.
2. 음수가 있는지 확인해 봅니다.
3. 6보다 큰 수가 있나 확인합니다.


### 모두 그런가? `all`

`all` 함수는 **모든** 요소가 특정 조건을 만족한다면 `true`를 반환합니다.

```kotlin
fun main() {

//sampleStart
    val numbers = listOf(1, -2, 3, -4, 5, -6)            // 1

    val allEven = numbers.all { it % 2 == 0 }            // 2

    val allLess6 = numbers.all { it < 6 }                // 3
//sampleEnd

    println("Numbers: $numbers")
    println("All numbers are even: $allEven")
    println("All numbers are less than 6: $allLess6")
}
```

1. 여러 숫자를 담은 컬렉션을 준비했습니다.
2. 모든 숫자가 짝수인지 확인합니다.
3. 모든 수가 6보다 작은지 확인합니다.

### 없나? Function `none`

`none` 함수는, 어떤 조건에 해당하는 요소가 없는 경우에만 `true`를 반환합니다.

```kotlin
fun main() {

//sampleStart
    val numbers = listOf(1, -2, 3, -4, 5, -6)            // 1

    val allEven = numbers.none { it % 2 == 1 }           // 2

    val allLess6 = numbers.none { it > 6 }               // 3
//sampleEnd

    println("Numbers: $numbers")
    println("All numbers are even: $allEven")
    println("No element greater than 6: $allLess6")
}
```

1. 여러 숫자를 담은 컬렉션을 준비합니다.
2. 홀수가 하나도 없는지 확인합니다. (모두 짝수인지)
3. 6보다 큰 수가 없는지 확인합니다.

