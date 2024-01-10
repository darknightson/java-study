import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularTest {

    public static void main(String[] args) {
        String str;
        str ="\t\t\t()!@#$%^&*(     MILLION (Feat. Chin)()!@#$%^&*(\t\t\t \t\t\t";
        System.out.println("str = " + str);
        str = str.replaceAll("^\\s+", "");
        str = str.replaceAll("\\s+$", "");
        System.out.println("str = " + str);
        
        
        
        List<String> item = Arrays.asList("우리나라", "홍성호");
}
}
