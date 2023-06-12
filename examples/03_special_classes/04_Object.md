# 오브젝트 키워드

코틀린에서 클래스와 오브젝트는 대부분의 객체 지향 언어에서와 같은 방식으로 작동합니다. 청사진 역할을 하는 클래스를 하나 정의하고, 그 클래스의 여러 인스턴스(오브젝트)를 만들어 쓰곤 합니다.

```kotlin
import java.util.Random

class LuckDispatcher {                    // 1
    fun getNumber() {                     // 2
        var objRandom = Random()
        println(objRandom.nextInt(90))
    }
}

fun main() {
    val d1 = LuckDispatcher()             // 3
    val d2 = LuckDispatcher()

    d1.getNumber()                        // 4
    d2.getNumber()
}
```

1. 클래스(청사진)를 정의했습니다.
2. 메서드를 정의했습니다.
3. 클래스의 인스턴스를 만들었습니다.
4. 만든 인스턴스의 메서드를 호출했습니다.

코틀린에는 [**object** 키워드](https://kotlinlang.org/docs/reference/object-declarations.html)를 써서 특별한 단일 인스턴스를 만들 수 있습니다. 자바 개발을 해보신 분은 "단일"의 뜻이 싱글톤(singleton) 패턴 인스턴스를 의미한다고 보시면 됩니다. 여러 스레드에서 동시에 사용하려고 하더라도 딱 하나의 인스턴스만 생성됩니다.

코틀린에서는 단일(싱글톤) 인스턴스를 만들기 위해서 `object`를 정의하면 됩니다. 클래스도 아니고, 생성자도 따로 없고, 딱 하나의 지연(lazy) 인스턴스만 준비됩니다. 지연(lazy) 인스턴스라는 이유는, 해당 오브젝트가 처음 접근될 때 생성되고, 접근되지 않는다면 아예 생성되지 않기 때문입니다.

## `object` 식

아래에 `object` 식을 활용해서 속성들을 담고 있는 오브젝트를 쉽게 만들었습니다. 이렇게 간단히 할 때는 클래스를 선언할 필요 없이 오브젝트를 하나 만들어서 그 안에 멤버들을 선언해 두고 접근해 쓸 수 있습니다.

```kotlin
fun rentPrice(standardDays: Int, festivityDays: Int, specialDays: Int): Unit {  // 1

    val dayRates = object {                                                     // 2
        var standard: Int = 30 * standardDays
        var festivity: Int = 50 * festivityDays
        var special: Int = 100 * specialDays
    }

    val total = dayRates.standard + dayRates.festivity + dayRates.special       // 3

    print("Total price: $$total")                                               // 4

}

fun main() {
    rentPrice(10, 2, 1)                                                         // 5
}
```

1. 파라미터들을 받는 함수를 만들었습니다.
2. 결괏값을 계산하려고 오브젝트를 하나 만들었습니다.
3. 오브젝트의 속성들을 읽었습니다
4. 결과를 프린트합니다.
5. 함수를 호출했습니다. 이때 해당 오브젝트가 생성됩니다.

## `object` 단일 인스턴스

`object` 선언을 할 수도 있습니다. 식의 형태가 아니라면, 변수에 값을 대입하는 용도로 쓸 수 없습니다. 별도의 인스턴스를 만들지 않고, 해당 오브젝트의 멤버에 곧바로 접근할 수 있습니다.

```kotlin
object DoAuth {                                                 // 1
    fun takeParams(username: String, password: String) {        // 2
        println("input Auth parameters = $username:$password")
    }
}

fun main(){
    DoAuth.takeParams("foo", "qwerty")                          // 3
}

```

1. 오브젝트를 선언했습니다.
2. 오브젝트 메서드를 정의했습니다.
3. 메서드를 호출했습니다. 보통은 메서드 호출 시점에 오브젝트가 생성되곤 합니다.

## 동반 오브젝트 Companion Objects

클래스 정의 안쪽에 선언하는 **동반 오브젝트**를 만들 수 있습니다. 문법적으로 자바의 정적(static) 메서드와 비슷하게 클래스 이름을 통해서 해당 오브젝트 멤버에 접근할 수 있습니다. 하지면 코틀린에서 동반 오브젝트를 쓸만한 상황이라면, 패키지에 곧바로 함수를 선언해 쓰는 방법을 고려해 주세요.

```kotlin
class BigBen {                                  //1
    companion object Bonger {                   //2
        fun getBongs(nTimes: Int) {             //3
            for (i in 1 .. nTimes) {
                print("BONG ")
            }
        }
    }
}

fun main() {
    BigBen.getBongs(12)                         //4
}
```

1. 클래스를 정의합니다.
2. 동반 오브젝트를 선언합니다. 이름은 생략할 수도 있습니다.
3. 동반 오브젝트에 함수를 정의했습니다.
4. 클래스 이름을 통해서 동반 오브젝트에 있는 메서드를 호출했습니다.
