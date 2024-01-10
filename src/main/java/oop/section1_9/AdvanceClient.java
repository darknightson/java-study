package oop.section1_9;

public class AdvanceClient {
    public int someMethod(AdvanceCalculateCommand calculateCommand) {
        AdvanceCalculateType calculateType = calculateCommand.getCalculateType();
        int num1 = calculateCommand.getNum1();
        int num2 = calculateCommand.getNum2();
        int result = calculateType.calculate(num1, num2); // 릭팩토링 결과 변경 없이 코드의 구조를 재조정 하는 것 가독성을 높이거나 유지보수를 편하게 함.
        return result;
    }
}
