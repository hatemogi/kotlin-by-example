# run 블록

`let`과 마찬가지로, `run`도 표준 라이브러리에 있는 블록 함수입니다. 기본적으로, 주어진 코드 블록을 실행하고 결괏값을 반환하는 점이 같습니다.
`run`이 다른 점은, 대상 오브젝트를 `it`이 아닌, `this`로 접근한다는 점입니다. 코드블록 안에서 원래 오브젝트의 메서드를 주로 호출하는 경우에 유용합니다.

```kotlin

fun main() {
//sampleStart
    fun getNullableLength(ns: String?) {
        println("대상 \"$ns\":")
        ns?.run {                                                  // 1
            println("\t비었나? => " + isEmpty())                    // 2
            println("\t길이 => $length")
            length                                                 // 3
        }
    }
    getNullableLength(null)
    getNullableLength("")
    getNullableLength("코틀린에서 어떤 문자열")
//sampleEnd
}
```

1. 주어진 코드블록을 null-가능 변수에 대해 실행했습니다. `null`이므로 무시합니다.
2. `run` 코드블록 안에서는 원래 오브젝트의 멤버에 곧바로 접근할 수 있습니다.
3. 주어진 `String`이 null이 아니라면, `run` 코드블록은 해당 문자열의 길이를 결괏값으로 돌려줍니다.
