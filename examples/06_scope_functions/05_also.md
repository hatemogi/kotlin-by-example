# also 블록

`also` 블록도 `apply` 블록과 비슷하게 동작합니다. 주어진 코드블록을 수행하고 오브젝트 자체를 반환합니다. 블록 안에서 오브젝트는 `it`으로 접근합니다. 다른 함수에 파라미터로 전달하기 편리합니다. 로그를 남긴다거나 하는 추가 작업을 할 때 쓰기 좋습니다.

```kotlin
data class Person(var name: String, var age: Int, var about: String) {
    constructor() : this("", 0, "")
}

fun writeCreationLog(p: Person) {
    println("${p.name} 인스턴스를 만들었습니다.")
}

fun main() {
//sampleStart
    val jake = Person("Jake", 30, "안드로이드 개발자")      // 1
        .also {                                          // 2
            writeCreationLog(it)                         // 3
    }
//sampleEnd
}
```

1. 주 생성자로 `Person()` 오브젝트를 생성했습니다.
2. `also` 블록을 실행했고, 그 반환값은 원래 오브젝트입니다.
3. 원래 오브젝트(`it`)를 파라미터로 주어 로그를 남기는 함수를 호출했습니다.