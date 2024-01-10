public class NumberCheck {

    public static void main(String[] args) {
        String value = "121212####ㅇㄴㄹㅁㅇㄹsdfsdf";

        if ( isNumberic(value)) {
            System.out.println(" 숫자입니다.");
        } else {
            System.out.println(" 숫자 아님");
        }
    }

    static boolean isNumberic(String s) { //숫자 판별 함수
        try {
            Double.parseDouble(s);
            return true;
        } catch(NumberFormatException e) {  //문자열이 나타내는 숫자와 일치하지 않는 타입의 숫자로 변환 시 발생
            return false;
        }
    }
}
