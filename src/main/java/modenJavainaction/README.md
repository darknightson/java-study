3장
1. boolean Predicate<T> , boolean BiPredicate<L, R>
  - test라는 추상 메서드를 정의하며 test는 제네릭 형식 T의 객체를 인수로 받아 불리언을 반환한다.
  - 주로 필터링 기능에 사용된다.
  - 블리언 형식이 필요한 상황에서 타입에 구애 받지 않고 Predicate 인터페이를 사용할 수 있다.

2. void Consumer<T>, void BiConsumer<T, U> 
  - 컨슈머 인터페이스는 제네릭 형식의 타입을 받아서 void 를 반화하는 accept 라는 추상 메서드를 정의한다.
  - T 형식의 타입을 받아서 어떤 동작을 수행하고 싶을 때 해당 인터페이스를 사용하면 된다.
  - 예를 들어 Integer 리스트를 인수로 받아서 각 항목에 어떤 동작을 수행하는 forEach 메서드를 정의할 수 있다.
  - 대표적으로 forEach 가 consumer 인터페이스 구현체이다.

3. R Function<T,R>, R BiFunction<T, U, R>

4. 형식정리
  - T -> R            : Function<T,R>
    . T 형식의 객체를 R 형식의 객체로 변환할 때 사용한다 예를 들면 <Apply, Integer> 로 사과의 무게 정보를 추출할 수 있다
  - (int, int) -> int : IntBinaryOperator
    . int 형식의 시그니처를 갖는 추상 메서드 applyAsInt 를 정의한다.
  - T -> void         : Consumer<T>
    . void 형식의 시그니처를 같는 추상 메서드 accept 를 정의 한다.
  - () -> T           : Supplier<T> OR Callable<T>  
    . T 형식의 시그니처를 같는 추상 메서드 get or call 을 정의하며, 객체 생성 시 사용한다.
  - (T, U) -> R       : BiFunction<T, U ,R> 
    . R 형식의 시그너처를 갖는 추상 메서드 apply 를 정의한다.

5. 함수형 인터페이스와 람다 요약. 사용 사례, 람다 예제, 사용할 수 있는 함수형 인터페이 등
  5.1 boolean Predicate<T> 
    - 람다 예제 : ( List<String> list -> list.isEmpty() )
  5.2 객체 생성 Supplier<T>
    - 람다 예제 : () -> new Apple();      
  5.3 객체에서 소비 Consumer<T>
    - 람다예제 : (Apple a) -> System.out.println(a.getName);
  5.4 두 값 조합 intBinaryOperator
    - 람다 예제 : (int a, int b) ->a + b
  5.5 두 객체 비교 BiFunction<T, U,R >
    - 람다 예제 : ( Apple a1, Apple a2, Integer) -> a1.getWeight().compareTo(a2.getWeight*())

6. 예외, 람다, 함수형 인터페이스의 관계
  - 함수형 인터페이스는 확인된 예외를 던지는 동작을 허용하지 않는다. 즉 예외를 던지는 람다 표현식을 만들려면
    확인된 예외를 선언하는 함수형 인터페이스를 직접 정의하거나  try catch 로 블럭을 감싸야 한다. 
    . @FunctionInterface public interface BufferReaderProcessor { xxxx method throws IOException



* Steam

1. Identity Function
- 어떤 타입을 받아서 같은 타입을 리턴하는 것
- 입력 값을 받아서 그대로 리턴한다.
- 그냥 받아서 리턴하는 것
- 그럼 이게 왜 필요할까?

2. Stream 은 두 종류의 메소드가 있다.
   2.1 intermediate operation method
    - 중간 단계 요청 예를 들어 filter, map등 중간에서 처리하는 로직이 들어가는 것
    - stream 을 리턴하기 때문에 계속 method chaining 를 통해서 무엇을 해야할지 스트림에게 지시할 수 있다. 아래처럼..
    - Option<Integer> result = list.stream
      .filter( i -> i > 10 ) -> intermediate operation method
      .map(i -> i * 2) -> intermediate operation method
      .sorted();거
      .distinct : 중복제거
      .findFirst(); -> terminal operation method ( 결과를 리턴하기 때문에..)
    
    2.2 terminal operation method ( 마지막 결과를 리턴하는 함수 )
    - findFirst()
    - collect(toList()) : 결과 값을 리스트로 만든다.
    - collect(toSet())  : 결과 값을 셋으로 만든다.
    - joining : string return 하면 문자사이를 연결
    - count : 전체 카운트
    - reduce :     
      2.3 주로 사용하는 stream 메소드
    - filter : 리스트 내에 담긴 값을 필터링한다. boolean predicate<t>
    - map : 리스트 내에 담긴 값을 같은 타입 혹은 다른 타입으로 리턴한다. R Function<T,R>  

3. Stream 메서드 
  3.1 Filter
    - 만족하는 데이터만 걸래내는데 사용
    - Predicate 에 true 를 반환하는 데이터만 리턴
    - Stream<T> filter(Predicate<? super T> pridicate )
  3.2 map
    - 데이터를 변형하는데 사용 -> 예를들어서 int 2개를 받아서 합산하거나 등등 데이터 변
      또는, int 넘겨서 "string number" + i 이런식으로 반환값이 다른경우
    - 데이터에 해당 함수가 적용된 결과물을 제공하는 stream 을 리턴
    - <R> Stream<R> map(Function<? super T, ? extends R> mapper
  3.3 Stream 의 구성 요서
    - Source ( 소스, 배열 )
    - Intermediate Operations ( 중간 처리 ) filter, map
    - Terminal Operation ( 종결 처리 ) Collect, reduce
      . findFirst()
      . collect(toList()) : 결과 값을 리스트로 만든다.
      . collect(toSet())  : 결과 값을 셋으로 만든다.
      . joining : string return 하면 문자사이를 연결
      . count : 전체 카운트
      . reduce   
    
    
