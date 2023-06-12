# 같은지 비교

코틀린에서는 구조적으로 비교할 때 `==`를 쓰고, 참조값을 비교할 때 `===`를 씁니다. 정확하게는, `a == b`가 `if (a == null) b == null else a.equals(b)`로 컴파일되는 방식입니다.

```kotlin
fun main() {
//sampleStart

  val authors = setOf("셰익스피어", "헤밍웨이", "트웨인")
  val writers = setOf("트웨인", "셰익스피어", "헤밍웨이")

  println(authors == writers)   // 1
  println(authors === writers)  // 2
//sampleEnd
}
```

1. `authors.equals(writers)`를 호출하게 되고, 집합은 요소의 순서를 무시하기 때문에, 결과적으로 `true`를 반환합니다.
2. `authors`와 `writers`는 다른 인스턴스(참조값)이기 때문에 `false`를 반환합니다.
