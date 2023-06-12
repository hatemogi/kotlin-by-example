# with 블록

`with`는 (확장 함수가 아닌) 일반 함수인데, 주어진 코드블록 안에서, 파라미터로 전달한 대상의 멤버에 접근할 때 인스턴스 이름을 생략할 수 있습니다.

```kotlin
class Configuration(var host: String, var port: Int)

fun main() {
    val configuration = Configuration(host = "127.0.0.1", port = 9000)

//sampleStart
    with(configuration) {
        println("$host:$port")       // 1
    }

    // instead of:
    println("${configuration.host}:${configuration.port}")
//sampleEnd
}
```

1. with 블록 안에서는 `configuration.host` 대신에 `host`로 간단히 접근했습니다.