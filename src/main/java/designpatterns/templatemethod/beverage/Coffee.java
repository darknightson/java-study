package designpatterns.templatemethod.beverage;

public class Coffee extends BeverageTemplate {
    @Override
    void brew() {
        System.out.println("커피 에스프레소를 만든다.");
    }

    @Override
    void addCondiments() {
        System.out.println("설탕 또는 우유를 추가한다.");
    }
}
