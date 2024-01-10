package cleanCode.objectAndDataStructures.oop;

/**
 * 객체 지향적은 도형 클래스 여기서 area는 도형의 면적을 구하는 메서드이며 다형섣Polymorphic 메서드이다.
 * Geometry 클래스는 필요 없으며 새도형을 추가해도 기존 함수에는 아무런 영향을 미치지지 않는다.
 * 반면 새 함수를 추가하고 싶다면 도형 클래스를 전부 고쳐야 한다.
 */
public interface Sharp {

    public double area();
}
