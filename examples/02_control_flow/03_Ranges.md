# 범위 Ranges

코틀린에서 다양한 방식으로 범위를 정의할 수 있습니다.

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

1. 0부터 3(마지막 포함)까지 범위를 차례로 처리했습니다. C/C++/Java 같은 언어에서 `for (i = 0; i <= 3; ++i)`로 쓰는 것과 비슷합니다.
2. 0부터 3(마지막 제외)까지 범위를 순회했습니다. 파이썬의 반복문이나 C/C++/Java 같은 언어들에서의 `for (i = 0; i < 3; ++i)` 구문과 비슷합니다.
3. 연속 요소에서 몇 단계씩 증가할 지 지정했습니다.
4. 특정 범위를 거꾸로 순회했습니다.

## 문자(Char) 범위

```kotlin
fun main() {
//sampleStart
    for (c in 'a'..'d') {              // 1
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

1. 문자 범위를 알파벳 순서대로 순회했습니다.
2. 문자 범위에도 `step`이나 `downTo`를 쓸 수 있습니다.

## `if`문 안에서 범위

```kotlin
fun main() {
//sampleStart
    val x = 2
    if (x in 1..5) {            // 1
        print("x는 1에서 5 사이의 수")
    }
    println()

    if (x !in 6..10) {          // 2
        print("x는 6에서 10 사이의 수가 아님")
    }
//sampleEnd
}
```

1. 값이 범위 안에 있는지 확인했습니다.
2. `!in`는 `in`의 반대입니다.
