package designpatterns.templatemethod.beverage;

public class Tea extends BeverageTemplate {
    @Override
    void brew() {
        System.out.println("티를 만든다.");
    }

    @Override
    void addCondiments() {
        System.out.println("adding lemon");
    }
}
