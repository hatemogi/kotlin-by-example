# apply 블록

오브젝트에 대해 호출하는 `apply` 블록은 주어진 코드블록을 수행한 다음, 전체 반환값으로 원래 오브젝트를 그대로 돌려줍니다. 코드블록 안에서는 객체에 접근할 때 `this`로 참조할 수 있습니다. 오브젝트를 초기화할 때 편리하게 쓸 수 있습니다.

```kotlin
data class Person(var name: String, var age: Int, var about: String) {
    constructor() : this("", 0, "")
}

fun main() {
//sampleStart
    val jake = Person()                                     // 1
    val stringDescription = jake.apply {                    // 2
        name = "Jake"                                       // 3
        age = 30
        about = "안드로이드 개발자"
    }.toString()                                            // 4
//sampleEnd
    println(stringDescription)
}
```


1. `Person()` 인스턴스를 기본 속성값으로 만들었습니다.
2. 만든 인스턴스에 대해 코드블록을 실행합니다.
3. `apply`안에서는, `jake.name = "Jake"`로 쓴 것과 동일합니다.
4. 전체 반환값은 인스턴스 자체가 됩니다. 그래서, 곧바로 이어서 다른 메서드(`.toString()`)를 호출했습니다.
