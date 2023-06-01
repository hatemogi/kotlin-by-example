# 문자열 템플릿 String Templates

[문자열 템플릿](https://kotlinlang.org/docs/reference/basic-types.html#string-templates)은 문자열 안에 변수를 담아서 표현할 수 있게 해줍니다. 실제 해당 문자열이 쓰이는 시점에 (예를들어, `println`에 전달된다거나 할 때) 문자열 안에 있는 식들이 모두 평가되어 해당 값으로 치환됩니다.

```kotlin
fun main() {
//sampleStart
    val greeting = "Kotliner"

    println("Hello $greeting")                  // 1
    println("Hello ${greeting.uppercase()}")    // 2
//sampleEnd
}
```

1. 변수를 담은 문자열을 프린트했습니다. 치환을 위한 변수 참조는 `$` 기호로 시작합니다.
2. 식을 담은 문자열을 프린트했습니다. 식도 `$`로 시작하고 중괄호(`{}`)로 감싸서 표기합니다.

