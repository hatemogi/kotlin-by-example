# 위임속성

코틀린에 있는 [위임속성](http://kotlinlang.org/docs/reference/delegated-properties.html) 기능은 인스턴스의 `set`과 `get` 속성에 접근하는 걸 위임할 수 있게 해 줍니다. 위임할 객체에는 `getValue` 메서드가 꼭 있어야 합니다. 변경 가능한(mutable) 속성이라면 `setValue` 메서드도 작성해야 합니다.

```kotlin
import kotlin.reflect.KProperty

class Example {
    var p: String by Delegate()                                               // 1

    override fun toString() = "예제 클래스"
}

class Delegate() {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {        // 2
        return "$thisRef, '${prop.name}' 속성을 위임했습니다!"
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) { // 2
        println("$thisRef 인스턴스에 있는 ${prop.name} 속성으로 지정된 값은 ${value}입니다.")
    }
}

fun main() {
    val e = Example()
    println(e.p)
    e.p = "NEW"
}
```

1. `Delegate` 인스턴스의 `String` 타입 속성을 프로퍼티 `p`로 위임했습니다. 위임할 객체는 `by` 키워드 뒤에 선언했습니다.
2. 위임 메서드를 구현했습니다. 항상 이런 파라미터 타입을 씁니다. 구현 자체는 필요한 나름의 방식으로 구현하면 됩니다. 만약 불변(immutable) 속성이라면 `getValue` 메서드만 작성해도 됩니다.

## 표준 위임속성

코틀린 표준 라이브러리에는 `lazy`, `observable` 같은 유용한 기본 위임속성들이 있습니다. 예를 들어, `lazy` 속성은 지연 초기화에 사용합니다.

```kotlin
class LazySample {
    init {
      println("created!")            // 1
    }

    val lazyStr: String by lazy {
        println("계산!")          // 2
        "지연 값"
    }
}

fun main() {
    val sample = LazySample()         // 1
    println("lazyStr = ${sample.lazyStr}")  // 2
    println(" = ${sample.lazyStr}")  // 3
}
```

1. 인스턴스 생성 시 `lazy` 속성은 아직 초기화되지 않은 상태입니다.
2. 처음 `get()`이 호출되면 람다식을 실행한 결과가 반환되고, 이 값이 보관됩니다.
3. 이후 `get()` 호출은 최초 보관된 값을 그대로 반환합니다.

스레드 안전성을 고려한다면, `blockingLazy()`를 씁니다. 이는 해당 값이 딱 한 스레드에서만 계산되도록 보장하고, 나머지 스레드에서 이 값을 사용하게 해 줍니다.

## 맵에 속성 저장하기

위임 속성을 써서, 맵에 속성들을 저장할 수도 있습니다. JSON 파싱 작업 같이 동적(dynamic) 작업을 할 때 유용하게 씁니다.

```kotlin
class User(val map: Map<String, Any?>) {
    val name: String by map                // 1
    val age: Int     by map                // 1
}

fun main() {
    val user = User(mapOf(
            "name" to "John Doe",
            "age"  to 25
    ))

    println("name = ${user.name}, age = ${user.age}")
}
```

1. `map`에 문자열 키를 위임해서, 속성 이름으로 쓰게 했습니다.

변경가능(mutable) 속성도 맵에 위임할 수 있습니다. 그런 위임속성에 값을 지정할 때, 맵의 값도 바뀌게 됩니다. 그러려면 읽기전용인 `Map` 타입 대신에 `MutableMap`을 써야 합니다.
