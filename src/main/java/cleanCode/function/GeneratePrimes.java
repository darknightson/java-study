package cleanCode.function;

public class GeneratePrimes {

    public static void main(String[] args) {
        int[] ints = generatePrimes(3);
        for ( int i : ints ) {
            System.out.println(i);
        }
    }
    public static int[] generatePrimes(int maxValue) {

        if ( maxValue > 2 ) { //  유일하게 유효한 경우
            // 선언
            int s = maxValue + 1; // 배열 크기
            boolean[] f = new boolean[s];
            int i;

            // 배열을 참으로 초기화
            for ( i = 0; i < s; i++)
                f[i] = true;

            // 소수가 아닌 알려진 숫자를 제거
            f[0] = f[1] = false;

            int j;
            for ( i = 2; i < Math.sqrt(s) + 1; i++ ) {
                if (f[i]) { // i가 남아있는 숫자라면 이 숫자의 배수를 구한다.
                    for ( j=2 * i; j < s; j += i )
                        f[j] = false; // 배수는 소수가 아니다.
                }
            }
            // 소수의 개수는?
            int count = 0;
            for ( i = 0 ; i < s; i++ ) {
                if ( f[i] )
                    count++; // 카운트 증가
            }
            int[] primes = new int[count];

            // 소수를 결과 배열로 이동
            for ( i = 0, j= 0; i < s; i++ ) {
                if ( f[i] ) // 소수이 경우에
                    primes[j++] = i;
            }
            return primes; // 소수를 반환
        }
        else
            return new int[0];
    }
}
