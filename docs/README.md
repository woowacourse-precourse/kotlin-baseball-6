1주차 미션 | 숫자 야구 게임
=======================
-----------------------

## 구현할 기능 목록
* 게임 시작 시 문구 출력
* __서로 다른 임의의 3자리 숫자__ 생성
* 3자리 숫자를 사용자로부터 입력(잘못된 값 입력 시 IllegalArgumentException 종료)
* 사용자가 입력한 숫자와 컴퓨터의 숫자 비교
    + __스트라이크__ - 자리 일치, 숫자가 일치할 경우
    + __볼__ - 자리 불일치, 숫자가 일치할 경우
    + __낫싱__ - 3개 숫자가 자리와 숫자 모두 일치하지 않은 경우
* 3개 숫자를 모두 맞추면 종료, 게임 재시작 / 완전 종료 여부 묻기

<br>

    코틀린은 처음이다... 쉬운 것부터 천천히!


### 게임 시작 시 문구 출력
게임 시작 시 문구를 출력시키는 것부터 구현해본다.   
콘솔 창에 '숫자 야구 게임을 시작합니다.' 라는 문자열을 출력한다.   

> *코틀린은 세미콜론을 붙이지 않는다!*

자바와 달리 코드의 마지막에 세미콜론을 붙이지 않아도 된다.   

콘솔에 출력하는 함수는 `println()` 이다.   
출력되는 문자열 마지막에 자동으로 개행이 된다.   
따라서 게임 시작 문구를 출력하고 싶다면 아래 코드로 동작할 수 있다.

    println("숫자 야구 게임을 시작합니다.")

<br>

### 서로 다른 임의의 3자리 숫자 생성
게임 시작 후, 컴퓨터는 사용자가 맞힐 3자리 숫자를 생성한다.   
3자리 숫자는 서로 다른 임의의 숫자이다.   
숫자를 저장할 변수를 생성하고,   
라이브러리를 활용하여 난수를 생성하고 변수에 저장하도록 구현하면 될 것이다.

과제를 설명하는 README.md의 **프로그래밍 요구 사항**을 살펴보면 사용해야할 라이브러리가 명시되어 있고,   
난수를 생성하는 함수도 적혀있다.

* 명시된 라이브러리 : `camp.nextstep.edu.missionutils`

감사하게도, 3자리의 서로 다른 난수를 생성하는 코드의 사용 예시를 제공해주고 있다. ~~감사합니다!~~   
코드의 내용은 아래와 같다.

    val computer = mutableListOf()
    while (computer.size() < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
      }
    }

*그냥 넘어갈 수는 없다!*   
구현을 위해 덥석 사용하기보다, 위 코드가 어떻게 동작하는지를 파악해볼 필요가 있다.  
요구 사항에 명시된 라이브러리부터 변수 선언, 코드에서 사용된 함수 등에 대해 알아보자.

...

__1. 라이브러리__

> 라이브러리를 알아보기 위해 구글 검색을 해보았지만, 마땅히 정보가 나오지 않았다.   
> 의구심을 품던 중 라이브러리의 이름이 눈에 들어왔다.   
> *camp, edu, missionutils*...   
> 처음에는 해당 라이브러리가 코틀린의 내장 라이브러리라고 생각했으나, 
> 구글링해도 나오지 않고, 라이브러리의 이름이 교육과 미션에 관련되어 있는 것을 보고서 
> 우테코에서 직접 제작한 라이브러리라는 생각이 들었다. 이에 프로젝트 내부 폴더를 하나하나 살펴보았다.   
> 
> 하지만 라이브러리에 관한 코드를 찾을 수 없었는데, `build.gradle.kts`파일을 확인하던 중 힌트를 얻을 수 있었다.   
> 
>     dependencies {
>         implementation("com.github.woowacourse-projects:mission-utils:1.1.0")
>     }
> 
> dependencies로 `mission-utils:1.1.0`이라는 라이브러리를 implement하고 있다.   
> 자세히 알지는 못하겠지만, 외부에서 라이브러리를 가져오고 있는 것 같았다.
> 
> 파일 탐색기의 프로젝트 폴더 아래에 있는 External Libraries를 확인해보니, 위의 implementation에 해당하는 폴더를 찾을 수 있었다.   
> 그리고 그 안에 `camp.nextstep.edu.missionutils` 라이브러리와 Console, Randoms 클래스의 코드를 확인할 수 있었다.   
> 프리코스 미션에 연수생들이 사용할 패키지를 직접 만들어주셨다. ~~정말 감사합니다!~~

라이브러리의 Randoms 클래스를 사용하기 전에 클래스의 멤버 변수와 메소드에 어떤 것이 구현되어 있는지 간단히 확인해보자.

자바를 바탕으로 구현된 클래스인 것 같다. 익숙한 패키지가 많지만 처음보는 패키지가 있어 살펴보려한다.
```kotlin
import java.util.concurrent.ThreadLocalRandom;
```
java.util.Random 패키지를 상속받아 동작하는 패키지이다. java.util.Random 패키지는 멀티 쓰레드 환경에서 
하나의 Random 인스턴스(시드)를 공유하여 전역적으로 동작하는데, 만약 여러 쓰레드가 동시에 난수 생성 동작을 행하게 되면 그 쓰레드들이 서로 싸운다(?).   
이 싸움을 경합이라 부른다. 경합하여 패배한 쓰레드는 이길 때 까지 같은 동작을 반복하며 경합하는데, 이 과정이 반복될 경우 성능 저하가 발생할 수 있다.

이를 해결하기 위해 ThreadLocalRandom을 사용하며, 이 친구는 전역이 아니라 각 쓰레드마다 생성된 Random 인스턴스를 사용하여 난수를 각각 생성하기 때문에,
위와 같은 동시성 문제가 발생하지 않는다.

아래는 Randoms 클래스의 멤버 변수와 메소드들의 동작 방식에 대한 간략한 설명을 적어놓은 것이다. 각 메서드별 자세한 구현 코드는 생략한다.
```java
public class Randoms {
    // ThreadLocalRandom의 current() 메서드를 이용하여 Random 객체 생성
    private static final Random defaultRandom = ThreadLocalRandom.current();

    // 생성자
    private Randoms() {
    }

    // 리스트의 숫자들 중 랜덤으로 한 숫자를 뽑는다.
    public static int pickNumberInList(final List<Integer> numbers) {
      ...
    }

    // 숫자 범위에서 랜덤하게 숫자를 뽑는다.
    public static int pickNumberInRange(final int startInclusive, final int endInclusive) {
      ...
    }

    // 지정된 숫자 범위 내에서 count 개의 난수를 뽑는다.(중복 x)
    public static List<Integer> pickUniqueNumbersInRange(
        final int startInclusive,
        final int endInclusive,
        final int count
    ) {
      ...
    }

    // 인자로 받은 리스트를 무작위로 섞어 반환한다.
    public static <T> List<T> shuffle(final List<T> list) {
      ...
    }

    // 리스트가 비어있는지를 검증한다.
    private static void validateNumbers(final List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("numbers cannot be empty.");
        }
    }

    // 지정된 숫자의 범위가 올바른지 검증한다.
    private static void validateRange(final int startInclusive, final int endInclusive) {
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException("startInclusive cannot be greater than endInclusive.");
        }
        if (endInclusive == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("endInclusive cannot be greater than Integer.MAX_VALUE.");
        }
        if (endInclusive - startInclusive >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("the input range is too large.");
        }
    }

    // 지정된 범위에 따른 count 크기가 올바른지 검증한다.
    private static void validateCount(final int startInclusive, final int endInclusive, final int count) {
        if (count < 0) {
            throw new IllegalArgumentException("count cannot be less than zero.");
        }
        if (endInclusive - startInclusive + 1 < count) {
            throw new IllegalArgumentException("count cannot be greater than the input range.");
        }
    }
}
```