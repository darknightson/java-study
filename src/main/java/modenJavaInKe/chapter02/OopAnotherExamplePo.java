package modenJavaInKe.chapter02;

public class OopAnotherExamplePo {
    public static void main(String[] args) {
        CalculateServicePo servicePo = new CalculateServicePo(new Addition());
        System.out.println("servicePo.calculate(1,2) = " + servicePo.calculate(2,1));
        servicePo = new CalculateServicePo(new Subtraction());
        System.out.println("servicePo.calculate(1,2) = " + servicePo.calculate(2,1));
        servicePo = new CalculateServicePo(new Multiplication());
        System.out.println("servicePo.calculate(1,2) = " + servicePo.calculate(2,1));
        servicePo = new CalculateServicePo(new Division());
        System.out.println("servicePo.calculate(1,2) = " + servicePo.calculate(2,1));
    }

}


