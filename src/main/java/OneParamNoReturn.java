interface Printable {
    void print(String s);
}

public class OneParamNoReturn {
    public static void main(String[] args) {
        Printable p;

        p = (String s) -> {
            System.out.println(s);
        };
        p.print("lambda exp one.");
    }
}
