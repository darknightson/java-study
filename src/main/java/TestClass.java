import java.util.HashSet;
import java.util.Set;

public class TestClass {

    private static final Set<String> internalAnnotationAttributes = new HashSet<>(4);

    static {
        internalAnnotationAttributes.add("message");
        internalAnnotationAttributes.add("groups");
        internalAnnotationAttributes.add("payload");
    }

    public static void main(String[] args) {
        for (String internalAnnotationAttribute : internalAnnotationAttributes) {
            System.out.println("internalAnnotationAttribute = " + internalAnnotationAttribute);
        }

    }

}
