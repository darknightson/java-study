package oop.section1_8;

import java.util.Map;

public class NullPointExceptionEx {
    public static void main(String[] args) {
        MapRepository mapRepository = new MapRepository();
        String value = mapRepository.getValue("key2");



        // Optional
        /*
        Optional.of(string)
        Optional.ofNullable(string)
        Optional.empty()
         */
    }

    private static String orelse() {
        String s = "orelse";
        System.out.println(s);
        return s;
    }
}
