# 스마트캐스트

코틀린 컴파일러는 대부분의 경우, 필요에 맞게 알아서, 자동으로 타입을 전환해줍니다.

1. null-가능 타입을 null-불가 타입으로 캐스트(타입전환)합니다.
2. 상위 타입에서 하위 타입으로 캐스트합니다.

```kotlin
import java.time.LocalDate
import java.time.chrono.ChronoLocalDate

fun main() {
//sampleStart
    val date: ChronoLocalDate? = LocalDate.now()    // 1

    if (date != null) {
        println(date.isLeapYear)                    // 2
    }

    if (date != null && date.isLeapYear) {          // 3
        println("윤년입니다!")
    }

    if (date == null || !date.isLeapYear) {         // 4
        println("올해에는 2월 29일이 없습니다...")
    }

    if (date is LocalDate) {
        val month = date.monthValue                 // 5
        println(month)
    }
//sampleEnd
}

```

1. null-가능 변수를 선언했습니다.
2. null-불가 타입으로 스마트캐스트되었습니다. 따라서 `isLeapYear`를 바로 쓸 수 있습니다.
3. 조건 안에서 스마트캐스트를 했습니다. (코틀린도 자바와 마찬가지로 [short-circuit](https://en.wikipedia.org/wiki/Short-circuit_evaluation)방식을 쓰기 때문에 가능합니다)
4. 조건 안에서 스마트캐스트 했습니다. (마찬가지입니다)
5. 하위 타입인 `LocalDate`로 캐스트되었습니다.

이런 방식으로, 뻔한 타입 변환을 명시하지 않고도 자동으로 변환해 쓸 수 있습니다.