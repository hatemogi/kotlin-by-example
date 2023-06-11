# 상속 Inheritance

코틀린은 일반적인 객체 지향 언어에서 지원하는 상속 기능을 모두 지원합니다.

```kotlin
open class Dog {                // 1
    open fun sayHello() {       // 2
        println("멍멍!")
    }
}

class Yorkshire : Dog() {       // 3
    override fun sayHello() {   // 4
        println("왈왈!")
    }
}

fun main() {
    val dog: Dog = Yorkshire()
    dog.sayHello()
}
```

1. 코틀린에서 클래스는 기본적으로 최종(final) 클래스입니다. 상속을 허용하려면 반드시 `open` 제어자를 붙여 표시해야 합니다.
2. 코틀린에서 메서드도 기본적으로 최종(final)입니다. 클래스와 마찬가지로 재정의(override)를 허용하려면 `open` 키워드를 앞에 붙여야 합니다.
3. 클래스를 상속하려면 `: SuperclassName()`같이 클래스 이름 뒤에 상속하고자 하는 상위 클래스명을 명시합니다. 빈괄호(`()`)는 상위 클래스의 기본 생성자를 사용하겠다는 뜻입니다.
4. 메서드나 속성을 재정의 하려면 `override` 키워드를 꼭 붙여야 합니다.

## 파라미터를 받는 생성자가 있는 클래스를 상속하기

```kotlin
//sampleStart
open class Tiger(val origin: String) {
    fun sayHello() {
        println("${origin}의 타이거 왈: 어흥!")
    }
}

class SiberianTiger : Tiger("시베리아")                  // 1

fun main() {
    val tiger: Tiger = SiberianTiger()
    tiger.sayHello()
}
//sampleEnd
```


1. 하위 클래스를 만들 때 상위 클래스의 파라미터 있는 생성자를 쓰려면, 생성자에 전달할 파라미터를 하위 클래스 선언시에 제공토록 합니다.

## 생성자 파라미터를 상위 클래스 생성자에도 전달하기

```kotlin
//sampleStart
open class Lion(val name: String, val origin: String) {
    fun sayHello() {
        println("$name, ${origin}에서 온 사자 왈: 으르렁!")
    }
}

class Asiatic(name: String) : Lion(name = name, origin = "인도") // 1

fun main() {
    val lion: Lion = Asiatic("심바")                             // 2
    lion.sayHello()
}
//sampleEnd
```

1. `Asiatic` 클래스 선언에 있는 `name`이 `var`도 아니고 `val`도 아닙니다. 이는 생성자 파라미터인데, 상위 클래스 `Lion`에 `name` 속성으로 전달했습니다.
2. `심바`라는 이름으로 `Asiatic` 인스턴스를 만들었습니다. `Lion` 생성자를 호출할 때 `심바`와 `인도`를 전달했습니다.

