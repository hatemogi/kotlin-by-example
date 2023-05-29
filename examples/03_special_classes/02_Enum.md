# 열거 클래스 Enum Classes

[열거 클래스](https://kotlinlang.org/docs/reference/enum-classes.html)는 딱 정해진 갯수의 구분된 값들을 표현하는 데에 쓰는 타입입니다. 방향, 상태, 모드 등을 표현하기에 좋습니다.

```kotlin
enum class State {
    IDLE, RUNNING, FINISHED                           // 1
}

fun main() {
    val state = State.RUNNING                         // 2
    val message = when (state) {                      // 3
        State.IDLE -> "It's idle"
        State.RUNNING -> "It's running"
        State.FINISHED -> "It's finished"
    }
    println(message)
}

```

1. 열거 상수 세 개가 있는 간단한 열거 클래스를 선언했습니다. 상수의 수는 미리 정해져 있어야 하고 모두 서로 구분되는 다른 값이어야 합니다.
2. 열거 상수는 클래스 이름을 통해서 접근합니다.
3. 열거 값을 `when`-조건식에 쓸 때에는 컴파일러가 모든 경우의 수를 모두 다루었는 지 확인할 수 있기 때문에 `else`-조건이 없어도 됩니다.

열거 클래스는 보통 클래스와 마찬가지로 속성이나 메서드를 추가할 수 있고, 각각의 열거 상수는 세미콜론으로 구분해 선언합니다.

```kotlin

enum class Color(val rgb: Int) {                      // 1
    RED(0xFF0000),                                    // 2
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00);

    fun containsRed() = (this.rgb and 0xFF0000 != 0)  // 3
}

fun main() {
    val red = Color.RED
    println(red)                                      // 4
    println(red.containsRed())                        // 5
    println(Color.BLUE.containsRed())                 // 6
    println(Color.YELLOW.containsRed())               // 7
}

```

1. 열거 클래스에 속성 한 개와 메서드 하나를 정의했습니다.
2. 이 경우 각각의 열거 상수에 생성자 파라미터를 하나씩 전달해야 합니다.
3. 각각의 열거 클래스 멤버는 세미콜론으로 끊어서 나열합니다.
4. 기본 `toString` 메서드는 상수값 자체를 반환합니다. 이 경우 `"RED"`입니다.
5. 열거 상수의 메서드를 호출했습니다.
6. 열거 클래스 이름을 통해 메서드를 호출했습니다.
7. `RED`와 `YELLOW`의 RGB 색상값은 앞부분 비트가 모두 `FF`이기 때문에 `true`를 반환합니다.