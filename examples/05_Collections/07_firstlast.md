# 처음과 끝 first, last

### `first`, `last`

이 함수들은 각각 어떤 컬렉션의 첫번째와 마지막 요소를 반환합니다. 조건을 주어서 찾을 수도 있는데, 그 경우 조건에 해당하는 첫 요소나 마지막 요소를 찾아줍니다.

컬렉션이 비어있거나 조건에 해당하는 값이 없다면, `NoSuchElementException` 예외가 발생합니다.

```kotlin
fun main() {

//sampleStart
    val numbers = listOf(1, -2, 3, -4, 5, -6)            // 1

    val first = numbers.first()                          // 2
    val last = numbers.last()                            // 3

    val firstEven = numbers.first { it % 2 == 0 }        // 4
    val lastOdd = numbers.last { it % 2 != 0 }           // 5
//sampleEnd

    println("Numbers: $numbers")
    println("First $first, last $last, first even $firstEven, last odd $lastOdd")
}
```

1. 여러 숫자를 담은 컬렉션을 만들었습니다.
2. 첫번째 요소를 구했습니다.
3. 마지막 요소를 구했습니다.
4. 첫 짝수를 구했습니다.
5. 마지막 홀수를 구했습네다.

### `firstOrNull`, `lastOrNull`

이 함수들은 위 함수들과 거의 같지만, 한가지 차이점이 있습니다. 해당 값이 없는 경우 예외를 발생시키는 대신에 `null`을 반환합니다.

```kotlin
fun main() {

//sampleStart
   val words = listOf("foo", "bar", "baz", "faz")         // 1
   val empty = emptyList<String>()                        // 2

   val first = empty.firstOrNull()                        // 3
   val last = empty.lastOrNull()                          // 4

   val firstF = words.firstOrNull { it.startsWith('f') }  // 5
   val firstZ = words.firstOrNull { it.startsWith('z') }  // 6
   val lastF = words.lastOrNull { it.endsWith('f') }      // 7
   val lastZ = words.lastOrNull { it.endsWith('z') }      // 8
//sampleEnd

   println("Empty list: first is $first, last is $last")
   println("Word list: first item starting with 'f' is $firstF, first item starting with 'z' is $firstZ")
   println("Word list: last item ending with 'f' is $lastF, last item ending with 'z' is $lastZ")
}
```

1. 단어들을 담은 컬렉션을 만들었습니다.
2. 빈 컬렉션을 준비했습니다.
3. 빈 컬렉션에서 첫 요소를 구했습니다. `null`이 반환됩니다.
4. 빈 컬렉션에서 마지막 요소를 구했습니다. 마찬가지로 `null`이 반환됩니다.
5. 'f'로 시작하는 첫 단어를 구합니다.
6. 'z'로 시작하는 첫 단어를 구합니다.
7. 'f'로 끝나는 마지막 단어를 구합니다.
8. 'z'로 끝나는 마지막 단어를 구합니다.
