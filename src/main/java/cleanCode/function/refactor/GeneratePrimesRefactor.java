package cleanCode.function.refactor;

public class GeneratePrimesRefactor {

    private static boolean[] crossedOut;
    private static int[] result;

    public static int[] generatePrimes(int maxValue) {
        if ( maxValue < 2 )
            return new int[0];
        else {
            uncrossIntegersUpTo(maxValue);
            crossOutMultiples();
        }
        return null;
    }

    private static void crossOutMultiples() {

    }

    private static void uncrossIntegersUpTo(int maxValue) {
        crossedOut = new boolean[maxValue + 1];
        for ( int i = 2; i < crossedOut.length; i++ ) {
            crossedOut[i] = false;
        }
    }

}
