# 확장함수와 확장속성

코틀린에 있는 [확장 기능](https://kotlinlang.org/docs/reference/extensions.html)으로 이미 있는 특정 클래스에 새로운 멤버를 나중에 추가할 수 있습니다. 확장함수와 확장속성이 있고, 둘 다 보통의 함수와 속성처럼 생겼지만 한 가지 중요한 차이점이 있습니다. 어떤 타입에서 확장할지 명시한다는 점이 다릅니다.

```kotlin
data class Item(val name: String, val price: Int)                                      // 1

data class Order(val items: Collection<Item>)

fun Order.maxPricedItemValue(): Int = this.items.maxByOrNull { it.price }?.price ?: 0  // 2
fun Order.maxPricedItemName() = this.items.maxByOrNull { it.price }?.name ?: "NO_PRODUCTS"

val Order.commaDelimitedItemNames: String                                              // 3
    get() = items.map { it.name }.joinToString()

fun main() {

    val order = Order(listOf(Item("빵", 5000), Item("와인", 29000), Item("생수", 1500)))

    println("가장 비싼 식료품: ${order.maxPricedItemName()}")                             // 4
    println("가장 비싼 가격: ${order.maxPricedItemValue()}")
    println("식료품: ${order.commaDelimitedItemNames}")                                  // 5

}
```

1. `Item`과 `Order`를 정의했습니다. `Order`는 `Item` 컬렉션이 들어있습니다.
2. `Order` 타입에 확장 함수를 추가했습니다.
3. `Order` 타입에 확장 속성을 추가했습니다.
4. `Order` 인스턴스에 있는 확장 함수를 호출했습니다.
5. `Order` 인스턴스에 있는 확장 속성을 읽었습니다.

심지어 `null`에도 확장 함수를 붙여서, 어떤 인스턴스가 null인지 아닌지 확인할 수 있습니다.

```kotlin
//sampleStart
fun <T> T?.nullSafeToString() = this?.toString() ?: "NULL"  // 1
//sampleEnd
fun main() {
    println(null.nullSafeToString())
    println("Kotlin".nullSafeToString())
}
```
