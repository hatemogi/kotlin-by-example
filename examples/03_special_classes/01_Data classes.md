# 데이터 클래스

[데이터 클래스](https://kotlinlang.org/docs/reference/data-classes.html)는 평범한 값들을 보관하는 용도의 클래스를 쉽게 만드는 데 씁니다. 데이터 클래스로 만들면 클래스를 복제하거나 문자열 표현을 하거나 컬렉션의 값으로 쓸 때 필요한 메서드들을 자동으로 만들어 줍니다. 물론, 이 메서드들을 필요에 따라 재정의할 수도 있습니다.

```kotlin
data class User(val name: String, val id: Int) {           // 1
    override fun equals(other: Any?) =
        other is User && other.id == this.id               // 2
}
fun main() {
    val user = User("석구", 1)
    println(user)                                          // 3

    val secondUser = User("석구", 1)
    val thirdUser = User("동석", 2)

    println("user == secondUser: ${user == secondUser}")   // 4
    println("user == thirdUser: ${user == thirdUser}")

    // hashCode() function
    println(user.hashCode())                               // 5
    println(secondUser.hashCode())
    println(thirdUser.hashCode())

    // copy() function
    println(user.copy())                                   // 6
    println(user === user.copy())                          // 7
    println(user.copy("동석"))                              // 8
    println(user.copy(id = 3))                             // 9

    println("name = ${user.component1()}")                 // 10
    println("id = ${user.component2()}")
}
```

1. `data` 제어자를 붙여서 데이터 클래스를 정의했습니다.
2. User 인스턴스이고 `id`값만 같다면 전체 값이 같다고 판단하도록, `equals` 메서드를 재정의했습니다.
3. `toString` 메서드는 자동으로 생성되며, `println`으로 확인해 보기 좋습니다.
4. 두 인스턴스의 `id`만 같다면 `equals` 메서드는 참을 반환합니다.
5. 데이터 클래스의 속성들이 같다면 `hashCode` 값도 똑같게 나옵니다.
6. 자동 생성된 `copy` 함수로 새 인스턴스를 쉽게 만들어 낼 수 있습니다.
7. `copy`는 새로운 인스턴스를 만들기 때문에, 원래의 인스턴스와 새 인스턴스는 다른 참조값을 갖습니다.
8. 데이터 클래스를 복제할 때 특정 속성을 바꿀 수 있습니다. `copy`는 클래스 생성자와 같은 순서로 파라미터를 받습니다.
9. `copy`에 이름지정(named) 파라미터를 전달해서 순서 상관없이 특정 속성 값을 바꿀 수 있습니다.
10. 자동 생성되는 `componentN` 함수를 써서, 데이터 클래스를 정의할 때의 속성들을 순서대로 접근할 수 있습니다.
