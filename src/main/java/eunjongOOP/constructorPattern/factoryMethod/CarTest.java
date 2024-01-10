package eunjongOOP.constructorPattern.factoryMethod;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class CarTest {

    public static void main(String[] args) {
        CarTest carTest = new CarTest();
        Car car = carTest.produceCar("Sonata");
    }

    private Car produceCar(String carName) {
        Objects.requireNonNull(carName, "carName must not be null");
        if (StringUtils.trimToEmpty(carName).isEmpty()) {
            throw new IllegalArgumentException("Invalid car name");
        }

        if ( carName.equals("Sonata") ) {
            return new Car(Car.SONATA);
        } else if ( carName.equals("Grandeur") ) {
            return new Car(Car.GRANDEUR);
        }
        else {
            throw new IllegalArgumentException("Invalid car name");
        }
    }
}
