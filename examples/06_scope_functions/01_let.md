# let 블록

코틀린 표준 라이브러리에 있는 `let` 함수는 범위를 제한할 때나 null-검사를 할 때 씁니다. 오브젝트에 대해 `let`으로 감싼 코드블록을 실행한 후 최종 결괏값을 전체 식(expression)의 반환값으로 돌려받습니다. `let`으로 전달한 코드블록 안에서는 `it`(다른 이름으로도 지정가능)으로 해당 오브젝트를 참조할 수 있습니다.

```kotlin
fun customPrint(s: String) {
    print(s.uppercase())
}

fun main() {
//sampleStart
    val empty = "test".let {               // 1
        customPrint(it)                    // 2
        it.isEmpty()                       // 3
    }
    println(" 비었나: $empty")


    fun printNonNull(str: String?) {
        println("\"$str\" 프린트:")

        str?.let {                         // 4
            print("\t")
            customPrint(it)
            println()
        }
    }

    fun printIfBothNonNull(strOne: String?, strTwo: String?) {
        strOne?.let { firstString ->       // 5
            strTwo?.let { secondString ->
                customPrint("$firstString : $secondString")
                println()
            }
        }
    }

    printNonNull(null)
    printNonNull("문자열")
    printIfBothNonNull("첫번째", "두번째")
//sampleEnd
}

```

1. `"test"` 문자열 값에 대해, 주어진 코드 블록을 실행합니다.
2. `it`으로 `"test"`에 접근합니다.
3. `let`은 블록 전체의 마지막 값을 반환합니다.
4. 안전한 호출방식을 썼기 때문에, `let`과 그 코드블록은 `null`이 아닌 경우에만 실행됩니다. `null`일 때는 실행되지 않고 무시됩니다.
5. `it` 대신에 다른 이름으로 접근할 수도 있습니다. 이 방법으로 통해, 바깥쪽 `let`구문에 참조되는 오브젝트에 접근했습니다.
