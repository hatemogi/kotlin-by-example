# 맵 조회 Map Element Access

맵에 `[]` 연산자를 쓰면 해당 키에 대응되는 값이 반환됩니다. 만약 해당 키가 맵에 없다면 `null`이 반환됩니다.
`getValue` 함수는 주어진 키에 대응하는 값을 반환하거나, 대응 값이 없다면 예외를 발생시킵니다. `withDefault`로 만든 맵의 경우에는, `getValue`로 없는 키를 조회해도 예외를 발생시키지 않고 기본값을 반환해 줍니다.

```kotlin
fun main(args: Array<String>) {

//sampleStart
    val map = mapOf("key" to 42)

    val value1 = map["key"]                                     // 1
    val value2 = map["key2"]                                    // 2

    val value3: Int = map.getValue("key")                       // 1

    val mapWithDefault = map.withDefault { k -> k.length }
    val value4 = mapWithDefault.getValue("key2")                // 3

    try {
        map.getValue("anotherKey")                              // 4
    } catch (e: NoSuchElementException) {
        println("Message: $e")
    }

//sampleEnd

    println("value1 is $value1")
    println("value2 is $value2")
    println("value3 is $value3")
    println("value4 is $value4")
}
```

1. 키 `"key"`에 해당하는 값인 42가 반환됩니다.
2. 키 `"key2"`는 이 맵에 없기 때문에 `null`을 반환합니다.
3. 키 `"key2"`가 이 맵에 없지만, 디폴트 값이 4가 반환됩니다.
4. 키 `"anotherKey"`가 이 맵에 없기 때문에, `NoSuchElementException` 예외가 발생합니다.
