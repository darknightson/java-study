package TestJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegularEx {

    public static void main(String[] args) {

        String input1 = "댄스가수유랑단 (김완선, 엄정화, 이효리, 보아 (BoA), 화사 (Hwa Sa))";
        String input2 = "김완선, 엄정화, 이효리, 보아 (BoA), 화사 (Hwa Sa, 주니어,我们的国家)";

        String input3 = "김완선, 엄정화, 이효리, 보아 (BoA, 주니어), 화사 (Hwa Sa, 주니어,我们的国家)";
        String input4 = "김완선,我们的国家, đất nước của chúng tôi, हमारा देश(강동원,우주)!@#$%^&*()@##$@$#%";

        String input5 = "김완선, 엄정화, 이효리, 보아 (BoA), 화사 (Hwa Sa))))";
        String input6 = "(김완선, 엄정화, 이효리, 보아 (BoA), 화사 (Hwa Sa))";
        String input7 = "(김완선, 엄정화)";
        String input8 = "화사(김완선)";
        String input9 = "김완선,엄정화(화사,보아)";
        String input10 = "선(유화)엄정화(화사,)";
        String input11 = "(Car the garden), 이효리(핑클)";


        List<String> extracted7 = processString(input11);
        for (String s : extracted7) {
            System.out.println("s1 = " + s);
        }
    }

    public static List<String> processString(String str) {
        List<String> result = new ArrayList<>();
        int depth = 0;
        int start = 0;
        boolean isRequestSave = false;
        boolean isCommaExists = false;
        boolean isResult = false;
        if ( str != null && str.length() != 0 && str.trim().length() != 0 ) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '(') {
                    depth++;
                    // 저장 로직 추가
                    isRequestSave = true;
                } else if (c == ')') {
                    depth--;
                    isRequestSave = false;

                } else if (c == ',' && depth == 0) {
                    result.add(str.substring(start, i).trim());
                    start = i + 1;
                }
                if ( isRequestSave) {
                    if (c == ',') {
                        isCommaExists = true;
                    }
                }
                if ( isRequestSave  && isCommaExists ) {
                    isResult = true;
                }
            }

            if ( isResult ) {
                System.out.println("변경되어야 한다.");
            }
            result.add(str.substring(start).trim());
        }
        return result;
    }

    private static List<String> getOnlyStrFromArray(String str){
        // 괄호 안에 포함된 comma 의 경우는 split 안하도록 modify by dark 2022.12.22 open ai
        return Arrays.stream(str.split(",(?![^\\(]*\\))"))
                .filter(st -> st != null && st.length() != 0 && st.trim().length() != 0)
                .map(String::trim)
                .collect(Collectors.toList());
    }
}


