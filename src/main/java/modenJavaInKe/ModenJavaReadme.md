* FunctionInterface
  - abstract method 를 하나만 가지는 인터페이스

* 대표적으로 사용되는 FunctionInterface 의 4가지
1. Function
    -> I O
2. Consumer
    -> I 
3. Predicate
    -> 입력 받고 boolean 값 으로 리턴한다.
4. Supplier
    -> O, lazy validation 용도.

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
   - sorted : 데이터가 순서대로 정렬된 스트림을 리턴한다.
     . 데이터의 종류에 따라서 Comparator 가 필요할 수 있다.
     . Stream<T> sorted();
     . Stream<T> sorted(Comparator<? super T> comparator);
   - distinct : 중복제거  
     