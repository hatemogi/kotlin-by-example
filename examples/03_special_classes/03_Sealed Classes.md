# 봉인 클래스 Sealed Classes

[봉인 클래스](https://kotlinlang.org/docs/reference/sealed-classes.html)로 상속을 제한할 수 있습니다. 클래스를 봉인하면, 그 봉인 클래스는 오로지 같은 패키지 안에서만 상속해서 하위 클래스를 만들 수 있습니다. 봉인 클래스가 선언된 패키지 외에 다른 패키지에서는 하위 클래스를 만들 수 없습니다.


```kotlin
sealed class Mammal(val name: String)                                                   // 1

class Cat(val catName: String) : Mammal(catName)                                        // 2
class Human(val humanName: String, val job: String) : Mammal(humanName)

fun greetMammal(mammal: Mammal): String {
    when (mammal) {                                                                     // 3
        is Human -> return "Hello ${mammal.name}; You're working as a ${mammal.job}"    // 4
        is Cat -> return "Hello ${mammal.name}"                                         // 5
    }                                                                                   // 6
}

fun main() {
    println(greetMammal(Cat("Snowy")))
}
```

1. 봉인 클래스를 정의했습니다.
2. 하위 클래스를 정의합니다. 하위 클래스 모두가 같은 패키지 안에 있습니다.
3. 봉인 클래스의 인스턴스를 `when` 식에서 쓰고 있습니다.
4. 스마트캐스트 기능으로 `Mammal`이 `Human`로 캐스팅되었습니다.
5. 스마트캐스트 기능으로 `Mammal`이 `Cat`으로 캐스팅되었습니다.
6. 봉인 클래스의 모든 하위 클래스를 다뤘으므로, `else` 조건은 필요치 않습니다. 봉인되지 않은 클래스 였다면 `else` 조건이 필요했을 겁니다
