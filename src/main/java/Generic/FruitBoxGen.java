package Generic;

import Fruit.Fruit;

import java.util.ArrayList;
import java.util.List;

public class FruitBoxGen<T> {

    private List<T> fruits = new ArrayList<>();

    public List<T> getFruits() {
        return fruits;
    }

    public void setFruits (T fruit ) {
        fruits.add(fruit);


    }

}
/*

 - T extends Fruit -> 타입 매개변수의 클래스가 Fruit 이거나 Fruit 를 상속(자식)받은 클래스만 사용가능
 - T super Fruit -> 타입 매개변수의 클래스가 Fruit 이거나 Fruit 의 상위 클래스(부모)여야 한다.
 - 와일드카드
   . ? 형태로 사용. 예를들어, List<?>
   . 모든 타입이 인자가 될 수 있다.
   . 부모든 자식이든 모두 올 수 있다.
   . ?에서 가져온 값은 Object 이므로 인자의 타입을 알 수 없다.
   . ? extends T 의 형태로 사용. 예를 들어, List<? extends T> -> T 혹은 T의 하위 클래스만 인자로 올 수 있다. ( ? extends Fruit )
     -> List<? extends T> 에서 get한 원소는 T이다.
     -> List<? extends T> 에서 add는 null만 삽입 할 수 있다.
   . List<? super T> 에서 get한 원소는 object이다.
   . List<? super T> 에서는 add 시 T혹은 T의 하위 클래스만 add 할 수 있다.
 */



