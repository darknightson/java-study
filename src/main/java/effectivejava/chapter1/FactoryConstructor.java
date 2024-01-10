package effectivejava.chapter1;

import AStart.afunctionInter.Product;

public class FactoryConstructor {

    private Long id;
    private String name;
    private Product product;

    // 기본 생성자는 아무곳에서나 생성 되지 못하게 막을 필요가 있다.
    private FactoryConstructor() {}

    private static final FactoryConstructor FACTORY_CONSTRUCTOR = new FactoryConstructor();

    public static FactoryConstructor getInstance() {
        return FACTORY_CONSTRUCTOR;
    }

    // 유연성을 갖는다.
    public static FactoryConstructor of(Long id, String name, Product product) {
        FactoryConstructor factoryConstructor = new FactoryConstructor();
        factoryConstructor.id = id;
        factoryConstructor.name = name;
        factoryConstructor.product = product;
        return factoryConstructor;

    }

}
