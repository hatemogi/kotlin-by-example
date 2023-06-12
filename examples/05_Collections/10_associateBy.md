# 맵으로 만들기

`associateBy` 함수와 `groupBy` 함수를 써서, 어떤 컬렉션에 있는 아이템들 담은 맵으로 만들 수 있습니다. `keySelector` 파라미터를 전달해서 각 아이템으로부터 키를 만들고, 선택적으로 `valueSelector` 함수도 전달해서 맵에 들어갈 값을 변환하는 용도로 쓸 수 있습니다.

두 함수의 차이점은, 컬렉션 요소들 중 똑같은 키값이 있는 경우에 드러납니다.

* `associateBy`는 이전 값은 무시하고 가장 마지막 값만 보관합니다.
* `groupBy`는 해당 키값에 일치하는 모든 요소를 리스트로 담아서 보관합니다.

반환되는 맵에 들어가는 키-값 순서는 원래 컬렉션에 담긴 아이템의 순서와 일치합니다.

```kotlin
fun main() {

//sampleStart

    data class Person(val name: String, val city: String, val phone: String) // 1

    val people = listOf(                                                     // 2
      Person("석구", "서울", "02-1234-5678"),
      Person("성태", "부산", "051-234-9876"),
      Person("효리", "제주", "064-123-4567"),
      Person("상순", "제주", "064-234-8901"))

    val phoneBook = people.associateBy { it.phone }                          // 3
    val cityBook = people.associateBy(Person::phone, Person::city)           // 4
    val peopleCities = people.groupBy(Person::city, Person::name)            // 5
    val lastPersonCity = people.associateBy(Person::city, Person::name)      // 6

//sampleEnd

    println("전화번호부: $phoneBook")
    println("전화번호별 도시: $cityBook")
    println("도시별 사는 사람들: $peopleCities")
    println("각 도시에 사는 마지막 사람: $lastPersonCity")
}
```

1. 사람을 표현하는 데이터 클래스를 정의했습니다.
2. 사람들을 컬렉션에 담았습니다.
3. 전화번호를 기준으로 맵을 만들었습니다. 여기서 `it.phone`이 `keySelector`가 되었습니다. `valueSelector`를 따로 지정하지 않았으므로, `Person` 인스턴스 자체가 맵에 값으로 들어갑니다.
4. 전화번호 기준으로 맵을 만들면서, 그 사람들이 사는 도시를 담았습니다. `Person::city`가 `valueSelector`로 주어졌으며, 맵에는 도시 정보만 값으로 담기게 됩니다.
5. 도시별로 사는 사람들을 담은 맵을 만들었습니다. 맵에 담긴 각각의 값은 사람들 "이름을 담고 있는 리스트"입니다.
6. 도시별로 살고 있는 사람들을 한 명씩만 담은 맵을 만듭니다. 원래 컬렉션 기준 순서로 따졌을 때, 해당 도시에 사는 마지막 사람만 맵에 담기게 됩니다.
