# 집합 Set

[집합](https://kotlinlang.org/docs/reference/collections.html)은 순서는 상관없지만 중복값이 없는 컬렉션입니다. `setOf()` 함수나 `mutableSetOf()`함수를 써서 집합을 만들 수 있습니다. 변이(mutable) 집합에 대한  읽기전용 뷰를 만들려면, `Set`으로 캐스팅하면 됩니다.

```kotlin
val openIssues: MutableSet<String> = mutableSetOf("uniqueDescr1", "uniqueDescr2", "uniqueDescr3") // 1

fun addIssue(uniqueDesc: String): Boolean {
    return openIssues.add(uniqueDesc)                                                             // 2
}

fun getStatusLog(isAdded: Boolean): String {
    return if (isAdded) "registered correctly." else "marked as duplicate and rejected."          // 3
}

fun main() {
    val aNewIssue: String = "uniqueDescr4"
    val anIssueAlreadyIn: String = "uniqueDescr2"

    println("Issue $aNewIssue ${getStatusLog(addIssue(aNewIssue))}")                              // 4
    println("Issue $anIssueAlreadyIn ${getStatusLog(addIssue(anIssueAlreadyIn))}")                // 5
}
```

1. 주어진 요소들을 담고 있는 `Set`을 만들었습니다.
2. 추가하려는 요소가 잘 들어갔는지 불린값을 반환합니다.
3. 함수의 파라미터에 따라 문자열을 반환합니다.
4. 새로운 요소를 `Set`에 잘 추가했으면 성공 메시지를 프린트합니다.
4. 이미 똑같은 요소가 있어서 추가할 수 없다면 실패 메시지를 프린트합니다.
