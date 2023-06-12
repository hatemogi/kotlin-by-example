# 맵 Map

[맵](https://kotlinlang.org/docs/reference/collections.html)은 키-값 쌍으로 이뤄진 컬렉션입니다. 각 키는 고유해야 하고, 쌍으로 연결된 값을 가져올 때 사용합니다. 맵을 만들려면 `mapOf()`나 `mutableMapOf()` 함수를 씁니다. [중위함수 to](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/to.html)를 쓰면 좀 더 간결하게 맵을 만들 수 있습니다. 변경가능(mutable) 맵의 읽기전용 뷰를 얻으려면 `Map`으로 캐스팅하면 됩니다.

```kotlin
const val POINTS_X_PASS: Int = 15
val EZPassAccounts: MutableMap<Int, Int> = mutableMapOf(1 to 100, 2 to 100, 3 to 100)   // 1
val EZPassReport: Map<Int, Int> = EZPassAccounts                                        // 2

fun updatePointsCredit(accountId: Int) {
    if (EZPassAccounts.containsKey(accountId)) {                                        // 3
        println("업데이트 $accountId...")
        EZPassAccounts[accountId] = EZPassAccounts.getValue(accountId) + POINTS_X_PASS  // 4
    } else {
        println("에러: 계정이 없습니다 (id: $accountId)")
    }
}

fun accountsReport() {
    println("EZ-Pass 현황:")
    EZPassReport.forEach {                                                              // 5
        k, v -> println("ID $k: 포인트 $v")
    }
}

fun main() {
    accountsReport()                                                                    // 6
    updatePointsCredit(1)                                                               // 7
    updatePointsCredit(1)
    updatePointsCredit(5)                                                               // 8
    accountsReport()                                                                    // 9
}
```

1. 변경가능 `Map`을 만들었습니다.
2. 그 `Map`의 읽기전용 뷰를 만들었습니다.
3. `Map`에 이미 해당 키가 있는지 확인합니다.
4. 해당하는 값을 읽어서 상수를 더합니다.
5. 불변 `Map`의 모든 요소에 대해 키-값 쌍을 프린트합니다.
6. 업데이트에 앞서, 계정 잔액을 확인해 둡니다.
7. 기존 계정을 두 번 업데이트합니다.
8. 계정을 없는데 업데이트하려면 에러 메시지가 프린트됩니다.
9. 업데이트를 끝내고 나서, 계정 잔액을 확인합니다.
