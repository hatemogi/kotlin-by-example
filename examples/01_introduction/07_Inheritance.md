# 상속 Inheritance

코틀린은 일반적인 객체 지향 언어에서 지원하는 상속 기능을 모두 지원합니다.

```kotlin
open class Dog {                // 1
    open fun sayHello() {       // 2
        println("wow wow!")
    }
}

class Yorkshire : Dog() {       // 3
    override fun sayHello() {   // 4
        println("wif wif!")
    }
}

fun main() {
    val dog: Dog = Yorkshire()
    dog.sayHello()
}
```

1. 코틀린에서 클래스는 기본적으로 최종(final) 클래스입니다. 상속을 허용하려면 `open` 제어자를 붙여 표시해야 합니다.
2. 코틀린에서 메서드도 기본적으로 최종(final)입니다. 클래스와 마찬가지로 재정의(override)하려면 `open` 키워드를 앞에 붙여야 합니다.
3. 클래스를 상속하려면 `: SuperclassName()`같이 클래스 이름 뒤에 상속하고자 하는 상위 클래스명을 명시합니다. 빈괄호(`()`)는 상위 클래스의 기본 생성자를 사용하겠다는 의미입니다.
4. 메서드나 속성을 재정의 하려면 `override` 키워드를 붙여야 합니다.

### 파라미터 생성자가 있는 클래스 상속 Inheritance with Parameterized Constructor

```kotlin
//sampleStart
open class Tiger(val origin: String) {
    fun sayHello() {
        println("A tiger from $origin says: grrhhh!")
    }
}

class SiberianTiger : Tiger("Siberia")                  // 1

fun main() {
    val tiger: Tiger = SiberianTiger()
    tiger.sayHello()
}
//sampleEnd
```


1. 하위 클래스를 만들 때 상위 클래스의 파라미터 있는 생성자를 쓰려면, 생성자에 전달할 파라미터를 하위 클래스 선언시에 제공토록 합니다.

### 생성자 파라미터를 상위 클래스에도 전달 Passing Constructor Arguments to Superclass

```kotlin
//sampleStart
open class Lion(val name: String, val origin: String) {
    fun sayHello() {
        println("$name, the lion from $origin says: graoh!")
    }
}

class Asiatic(name: String) : Lion(name = name, origin = "India") // 1

fun main() {
    val lion: Lion = Asiatic("Rufo")                              // 2
    lion.sayHello()
}
//sampleEnd
```

1. `Asiatic` 클래스 선언에 있는 `name`이 `var`도 아니고 `val`도 아닙니다. 이는 생성자 파라미터인데, 상위 클래스 `Lion`에 `name` 속성으로 전달했습니다.
2. `Rufo`라는 이름으로 `Asiatic` 인스턴스를 만들었습니다. `Lion` 생성자를 호출할 때 `Rufo`와 `India`를 전달했습니다.

