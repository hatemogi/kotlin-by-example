# 이름지정 파라미터 Named Arguments

코틀린도, 대부분의 프로그래밍 언어(자바, C++ 등)와 마찬가지로, 메서드나 생성자에 전달할 파라미터는 정의된 순서대로 전달됩니다. 코틀린에는 [이름지정 파라미터](https://kotlinlang.org/docs/reference/functions.html#named-arguments)도 있는데, 이는 파라미터 이름을 명시함으로써 파라미터 순서로 인한 실수를 줄여줍니다. 똑같은 타입의 두 파라미터를 나란히 전달하는 경우에 순서를 거꾸로 전달하는 것 같은 실수는 찾기도 어렵고 컴파일러에게 발견되지도 않습니다.

```kotlin
fun format(userName: String, domain: String) = "$userName@$domain"

fun main() {
//sampleStart
    println(format("mario", "example.com"))                         // 1
    println(format("domain.com", "username"))                       // 2
    println(format(userName = "foo", domain = "bar.com"))           // 3
    println(format(domain = "frog.com", userName = "pepe"))         // 4
//sampleEnd
}
```

1. 파라미터들을 전달해서 함수를 호출했습니다.
2. 도메인과 이용자 이름 파라미터를 거꾸로 전달했습니다.
3. 이름지정 파라미터를 써서 호출했습니다.
4. 이름지정 파라미터로 함수를 호출하면, 순서와 무관하게 옳바른 값이 전달됩니다.
