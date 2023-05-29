# 제너릭 Generics

[제너릭](https://kotlinlang.org/docs/reference/generics.html)은 현대의 프로그래밍 언어들에서 표준처럼 자리잡은 일반화 방법입니다. 제너릭 클래스와 함수는 공통 코드에서 어떤 특정 타입에서 독립적인 공통 코드를 잘 감싸서 쓸 수 있게 해서 코드 재사용성을 높여줍니다. `List<T>`에 있는 코드들이 타입 `T`에 관계 없이 잘 작동하는 것처럼요.

### 제너릭 클래스 Generic Classes

코틀린에서 제너릭을 쓰는 방법 중 첫번째는, 제너릭 클래스를 만드는 것입니다.

```kotlin
//sampleStart
class MutableStack<E>(vararg items: E) {              // 1

  private val elements = items.toMutableList()

  fun push(element: E) = elements.add(element)        // 2

  fun peek(): E = elements.last()                     // 3

  fun pop(): E = elements.removeAt(elements.size - 1)

  fun isEmpty() = elements.isEmpty()

  fun size() = elements.size

  override fun toString() = "MutableStack(${elements.joinToString()})"
}
//sampleEnd

fun main() {
  val stack = MutableStack(0.62, 3.14, 2.7)
  stack.push(9.87)
  println(stack)

  println("peek(): ${stack.peek()}")
  println(stack)

  for (i in 1..stack.size()) {
    println("pop(): ${stack.pop()}")
    println(stack)
  }
}

```


1. `MutableStack<E>`라는 제너릭 클래스를 정의했고, 여기서 `E`를 제너릭 타입 파라미터라고 부릅니다. 이를 사용할 때는 `MutableStack<Int>`처럼 `E` 자리에 `Int`처럼 구체적인 타입을 선언해서 씁니다.
2. 제너릭 클래스 안에서는, `E`는 다른 보통의 타입들과 마찬가지로 쓸 수 있습니다.
3. `E`를 반환 타입 자리에 쓸 수도 있습니다.

여기서 함수를 한줄로 줄여서 정의할 수 있는 축약 문법을 많이 쓴 점에 유의해주세요.

### 제너릭 함수 Generic Functions

어떤 함수의 내용이 특정 타입에 독립적이라면, [제너릭 함수](https://kotlinlang.org/docs/reference/generics.html#generic-functions)로 정의해도 됩니다. 예제로, 스택을 만드는 유틸리티 함수를 작성해 보겠습니다.

```kotlin
class MutableStack<E>(vararg items: E) {              // 1

  private val elements = items.toMutableList()

  fun push(element: E) = elements.add(element)        // 2

  fun peek(): E = elements.last()                     // 3

  fun pop(): E = elements.removeAt(elements.size - 1)

  fun isEmpty() = elements.isEmpty()

  fun size() = elements.size

  override fun toString() = "MutableStack(${elements.joinToString()})"
}

//sampleStart
fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)

fun main() {
  val stack = mutableStackOf(0.62, 3.14, 2.7)
  println(stack)
}
//sampleEnd
```

여기서, 컴파일러가 `mutableStackOf` 함수의 제너릭 파라미터를 추론할 수 있기 때문에, `mutableStackOf<Double>(...)`처럼 길게 쓰지 않은 점을 자세히 봐주세요.
