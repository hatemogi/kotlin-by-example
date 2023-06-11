# 반복문 Loops

코틀린에는 흔히 쓰는 반복문 구문인, `for`, `while`, `do-while` 모두를 지원합니다.

### `for`

코틀린에서의 `for` 구문은 대부분의 언어에서 쓰는 방식과 비슷하게 씁니다.

```kotlin
fun main(args: Array<String>) {
//sampleStart
    val cakes = listOf("당근", "치즈", "초콜릿")

    for (cake in cakes) {                               // 1
        println("맛있는 ${cake}케이크!")
    }

//sampleEnd
}
```

1. 리스트에 있는 모든 케이크에 대해 반복합니다.

### `while`과 `do-while`

`while`과 `do-while`도 대부분의 언어와 비슷하게 동작합니다.

```kotlin
fun eatACake() = println("케이크 먹기")
fun bakeACake() = println("케이크 굽기")

fun main(args: Array<String>) {
    var cakesEaten = 0
    var cakesBaked = 0

    while (cakesEaten < 5) {                    // 1
        eatACake()
        cakesEaten ++
    }

    do {                                        // 2
        bakeACake()
        cakesBaked++
    } while (cakesBaked < cakesEaten)

}
```

1. 조건이 참인 동안 해당 블록을 반복 수행합니다.
2. 일단 해당 블록을 수행한 다음, 조건을 확인합니다.

### 이터레이터 Iterators

클래스를 만들 때 `iterator` 연산자를 구현하면, 나만의 이터레이터를 정의할 수 있습니다.

```kotlin
class Animal(val name: String)

class Zoo(val animals: List<Animal>) {

    operator fun iterator(): Iterator<Animal> {             // 1
        return animals.iterator()                           // 2
    }
}

fun main() {

    val zoo = Zoo(listOf(Animal("얼룩말"), Animal("사자")))

    for (animal in zoo) {                                   // 3
        println("여기 ${animal.name} 있어요!")
    }

}
```

1. 클래스 안에 이터레이터를 정의했습니다. 반드시 `iterator`라는 이름으로 해야하고 `operator` 제어자를 붙여야 합니다.
2. 아래 요구 사항을 만족하는 이터레이터를 반환해야 합니다.
  * `next()`: `Animal`
  * `hasNext()`: `Boolean`
3. 내가 만든 이터레이터를 써서 동물원에 있는 동물들에 대해 반복했습니다.

이터레이터는 타입 안에 직접 선언하거나, 확장(extension) 함수의 형태로 타입 밖에서 따로 선언할 수도 있습니다.