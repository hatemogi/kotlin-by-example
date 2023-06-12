# 위임 패턴

코틀린에는 [위임 패턴](https://kotlinlang.org/docs/reference/delegation.html)을 구현하기 간편한 방법이 있습니다.

```kotlin
interface SoundBehavior {                                                          // 1
    fun makeSound()
}

class ScreamBehavior(val n:String): SoundBehavior {                                // 2
    override fun makeSound() = println("${n.toUpperCase()} !!!")
}

class RockAndRollBehavior(val n:String): SoundBehavior {                           // 2
    override fun makeSound() = println("I'm The King of Rock 'N' Roll: $n")
}

// Tom Araya is the "singer" of Slayer
class TomAraya(n:String): SoundBehavior by ScreamBehavior(n)                       // 3

// You should know ;)
class ElvisPresley(n:String): SoundBehavior by RockAndRollBehavior(n)              // 3

fun main() {
    val tomAraya = TomAraya("Thrash Metal")
    tomAraya.makeSound()                                                           // 4
    val elvisPresley = ElvisPresley("Dancin' to the Jailhouse Rock.")
    elvisPresley.makeSound()
}
```


1. `SoundBehavior`인터페이스를 정의했습니다.
2. `ScreamBehavior` 클래스와 `RockAndRollBehavior` 클래스는 해당 인터페이스를 구현했고, 각각 필요한 메서드를 작성했습니다.
3. `TomAraya` 클래스와 `ElvisPresley` 클래스도 마찬가지로 `SoundBehavior` 인터페이스를 구현했습니다. 인터페이스에 필요한 메서드를 직접 구현하지 않고, `by` 키워드로 다른 오브젝트에 위임했습니다.
4. `tomAraya`나 `elvisPresley`의 `makeSound()` 메서드를 호출하면, 각각 위임 오브젝트의 메서드가 불립니다.