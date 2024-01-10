package designpatterns.templatemethod.beverage;

public abstract class BeverageTemplate {

    final void makeBeverage() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    private void boilWater() {
        System.out.println("물을 끓인다");
    }
    private void pourInCup() {
        System.out.println("컵에 담는다.");
    }
    abstract void brew();
    abstract void addCondiments();


}
