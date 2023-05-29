# 헬로 월드

```kotlin
package org.kotlinlang.play         // 1

fun main() {                        // 2
    println("Hello, World!")        // 3
}
```

1. 보통 코틀린 코드는 패키지 안에 정의합니다. 패키지 선언은 필수는 아닙니다. 소스 파일에 패키지를 지정하지 않으면, 디폴트 패키지에 속하게 됩니다.
2. 코틀린 애플리케이션의 시작점은 `main` 함수입니다. 함수의 반환 타입이 지정하지 않았기 때문에, 아무것도 반환하지 않습니다.
3. `println`는 표준 출력에 한 줄을 씁니다. 암묵적으로 임포트(import)됩니다. 세미콜론(`;`)이 없어도 되는 점도 살펴봐 주세요.

만약, 애플리케이션 실행 파라미터를 입력 받으려면, `main` 함수가 `Array<String>` 타입의 파라미터를 받도록 합니다.

```kotlin
fun main(args: Array<String>) {
    println("Hello, World!")
}
```

