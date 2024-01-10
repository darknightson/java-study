package designpatterns.templatemethod.beverage;

public class TemplateMethodPatternExample {

    public static void main(String[] args) {
        BeverageTemplate coffee = new Coffee();
        coffee.makeBeverage();;
        BeverageTemplate tea = new Tea();
        tea.makeBeverage();
    }
}
