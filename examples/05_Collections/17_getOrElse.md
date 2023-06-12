# 안전한 조회

`getOrElse` 메서드로 컬렉션의 아이템에 안전하게 접근할 수 있습니다. 몇 번째 요소에 접근할지 인덱스에 더불어, 값이 없을 경우나 범위를 초과한 경우에 반환할 기본값을 지정합니다.

```kotlin
fun main() {

//sampleStart
    val list = listOf(0, 10, 20)
    println(list.getOrElse(1) { 42 })    // 1
    println(list.getOrElse(10) { 42 })   // 2
//sampleEnd
}
```

1. `1`번 인덱스에 있는 아이템을 구해 프린트합니다.
2. `10` 인덱스는 범위를 초과했기 때문에, 기본값인 `42`를 프린트했습니다.

## Map의 getOrElse

`Map`에 대해서도 `getOrElse` 메서드를 써서 특정 키로 조회할 수 있습니다.

```kotlin
fun main() {

//sampleStart
    val map = mutableMapOf<String, Int?>()
    println(map.getOrElse("x") { 1 })       // 1

    map["x"] = 3
    println(map.getOrElse("x") { 1 })       // 2

    map["x"] = null
    println(map.getOrElse("x") { 1 })       // 3
//sampleEnd
}
```

1. 맵에 `"x"` 키가 없으므로, 기본값을 프린트했습니다.
2. 이번에는 `"x"` 키에 해당하는 값인 `3`을 프린트합니다.
3. `"x"`가 다시 없어졌기에 기본 값을 프린트합니다.
