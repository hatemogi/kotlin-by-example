# 클래스 Classes

[클래스 선언](https://kotlinlang.org/docs/reference/classes.html#classes)은, 클래스 이름, 클래스 헤더(타입 파라미터, 주 생성자)에 이어 중괄호쌍(`{}`)으로 감싼 본문으로 구성합니다. 클래스에 본문이 없는 경우는 중괄호를 생략해도 됩니다.

```kotlin
class Customer                                  // 1

class Contact(val id: Int, var email: String)   // 2

fun main() {

    val customer = Customer()                   // 3

    val contact = Contact(1, "mary@gmail.com")  // 4

    println(contact.id)                         // 5
    contact.email = "jane@gmail.com"            // 6
}
```

1. 속성이나 추가 생성자 없이 `Customer`라는 이름으로 클래스를 선언했습니다. (본문이 없어서 중괄호도 생략했습니다)
2. 불변(immutable)속성 `id`와 변이(mutable)속성 `email`을 파라미터로 받는 생성자와 함께 클래스를 선언했습니다.
3. `Customer` 클래스의 기본 생성자로 인스턴스를 만들었습니다. 코틀린에서는 `new` 키워드를 따로 쓰지 않습니다.
4. `Contact` 클래스의 생성자에 두 파라미터를 전달해 인스턴스를 하나 만들었습니다.
5. `id` 속성을 읽었습니다.
6. `email` 속성값을 변경했습니다.
