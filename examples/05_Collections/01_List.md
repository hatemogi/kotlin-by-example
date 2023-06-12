# 리스트 List

[리스트](https://kotlinlang.org/docs/reference/collections.html)는 어떤 순서대로 나열한 컬렉션입니다. 코틀린의 리스트는 크게 두 종류가 있는데, 하나는 변경 가능한 리스트(`MutableList`)고, 다른 하나는 읽기전용 리스트(`List`)가 있습니다. 리스트를 만들려면, 표준 라이브러리에 있는 함수인 `listOf()`를 써서 읽기전용 리스트를 만들거나, `mutableListOf()` 함수를 써서 변경가능 리스트를 만듭니다. 리스트를 이후에 변경하지 못하게 막으려면, 리스트를 `List`로 캐스트(타입변경)해서 써도 됩니다.

```kotlin
val systemUsers: MutableList<Int> = mutableListOf(1, 2, 3)        // 1
val sudoers: List<Int> = systemUsers                              // 2

fun addSystemUser(newUser: Int) {                                 // 3
    systemUsers.add(newUser)
}

fun getSysSudoers(): List<Int> {                                  // 4
    return sudoers
}

fun main() {
    addSystemUser(4)                                              // 5
    println("전체 sudoers: ${getSysSudoers().size}")               // 6
    getSysSudoers().forEach {                                     // 7
        i -> println("이용자 ${i}에 대한 정보")
    }
    // getSysSudoers().add(5) <- Error!                           // 8
}
```

1. `MutableList`를 만들었습니다.
2. 그 리스트를 읽기 전용으로 캐스트(타입변경)했습니다.
3. `MutableList`에 새로운 아이템을 추가했습니다.
4. 읽기전용 `List`를 반환했습니다.
5. `MutableList`를 변경했습니다. 불변 리스트로 캐스팅해서 쓰던 것들도 모두 함께 변경됩니다. 실제로는 같은 인스턴스를 가리키고 있기 때문입니다.
6. 읽기전용 리스트의 크기를 조회했습니다.
7. 리스트 아이템을 차례로 읽어 프린트했습니다.
8. 읽기전용 리스트에 값을 쓰려고 하면 컴파일 에러가 발생합니다.
