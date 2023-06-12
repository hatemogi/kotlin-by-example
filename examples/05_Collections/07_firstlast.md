# 처음과 마지막

## `first`와 `last`

이 함수들은 컬렉션의 첫번째와 마지막 아이템를 반환합니다. 명제로 찾을 수도 있는데, 그 경우 명제에 참인 첫 아이템 또는 마지막 아이템을 찾아줍니다. 컬렉션이 비어있거나 조건에 해당하는 값이 없다면, `NoSuchElementException` 예외가 발생합니다.

```kotlin
fun main() {

//sampleStart
    val numbers = listOf(1, -2, 3, -4, 5, -6)            // 1

    val first = numbers.first()                          // 2
    val last = numbers.last()                            // 3

    val firstEven = numbers.first { it % 2 == 0 }        // 4
    val lastOdd = numbers.last { it % 2 != 0 }           // 5
//sampleEnd

    println("숫자들: $numbers")
    println("처음은 $first, 마지막은 $last, 첫 짝수는 $firstEven, 마지막 홀수는 $lastOdd")
}
```

1. 여러 숫자를 담은 컬렉션을 만들었습니다.
2. 첫번째 아이템을 구했습니다.
3. 마지막 아이템을 구했습니다.
4. 첫 짝수를 구했습니다.
5. 마지막 홀수를 구했습네다.

### `firstOrNull`와 `lastOrNull`

이 함수들은 위 함수들과 거의 같지만, 한가지 차이점이 있습니다. 해당 값이 없는 경우 예외를 발생시키는 대신에 `null`을 반환한다는 점이 다릅니다.

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

   println("빈 리스트에 대해: 처음은 $first, 마지막은 $last")
   println("단어 리스트: 'f'로 시작하는 첫 아이템은 $firstF, 'z'로 시작하는 첫 아이템은 $firstZ")
   println("단어 리스트: 'f'로 끝나는 마지막 아이템은 is $lastF, 'z'로 끝나는 마지막 아이템은 $lastZ")
}
```

1. 단어들을 담은 컬렉션을 만들었습니다.
2. 빈 컬렉션을 준비했습니다.
3. 빈 컬렉션에서 첫 아이템을 구했습니다. `null`이 반환됩니다.
4. 빈 컬렉션에서 마지막 아이템을 구했습니다. 마찬가지로 `null`이 반환됩니다.
5. 'f'로 시작하는 첫 단어를 구합니다.
6. 'z'로 시작하는 첫 단어를 구합니다.
7. 'f'로 끝나는 마지막 단어를 구합니다.
8. 'z'로 끝나는 마지막 단어를 구합니다.
