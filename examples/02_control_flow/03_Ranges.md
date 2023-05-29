# 범위 Ranges

코틀린에는 다양한 방식으로 범위를 정의할 수 있습니다.

```kotlin
fun main() {
//sampleStart
    for(i in 0..3) {             // 1
        print(i)
    }
    print(" ")

    for(i in 0 until 3) {        // 2
        print(i)
    }
    print(" ")

    for(i in 2..8 step 2) {      // 3
        print(i)
    }
    print(" ")

    for (i in 3 downTo 0) {      // 4
        print(i)
    }
    print(" ")

//sampleEnd
}
```

1. 0부터 3(마지막 포함)까지 범위를 차례로 처리했습니다. C/C++/Java 같은 언어에서 `for(i=0; i<=3; ++i)`로 쓰는 것과 비슷합니다.
2. 0부터 3(마지막 제외)까지 범위를 순회했습니다. 파이썬의 반복문이나 C/C++/Java 같은 언어들에서의 `for(i=0; i<3; ++i)` 구문과 비슷합니다.
3. 연속적인 요소에서 몇 단계씩 증가할 지 지정했습니다.
4. 특정 범위를 거꾸로 순회했습니다.

문자(Char) 범위도 지원합니다.

```kotlin
fun main() {
//sampleStart
    for (c in 'a'..'d') {        // 1
        print(c)
    }
    print(" ")

    for (c in 'z' downTo 's' step 2) { // 2
        print(c)
    }
    print(" ")

//sampleEnd
}
```

1. Iterates over a char range in alphabetical order.
1. 문자 범위를 알파벳 순서대로 순회했습니다.
2. Char ranges support `step` and `downTo` as well.
2. 문자 범위에도 `step`이나 `downTo`를 쓸 수 있습니다.

`if`문 안에서도 범위를 유용하게 쓸 수 있습니다.

```kotlin
fun main() {
//sampleStart
    val x = 2
    if (x in 1..5) {            // 1
        print("x is in range from 1 to 5")
    }
    println()

    if (x !in 6..10) {          // 2
        print("x is not in range from 6 to 10")
    }
//sampleEnd
}
```

2. `!in` is the opposite of `in`.
2. `!in`는 `in`의 반대입니다. .
