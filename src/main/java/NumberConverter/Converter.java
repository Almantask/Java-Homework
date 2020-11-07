package NumberConverter;

import java.util.Arrays;

public class Converter {
        public static int transform(String n) {
//  String numb = "CDXLIV";
            int a;
            int result = 0;
            String[] ary = n.split("");
            int aryNumb[] = new int[ary.length];
            int aryNumb1[] = new int[ary.length];
//        System.out.println(Arrays.toString(ary));
            for (int i = 0; i < ary.length; i++) {
                switch (ary[i]) {
                    case "I" -> aryNumb[i] = 1;
                    case "V" -> aryNumb[i] = 5;
                    case "X" -> aryNumb[i] = 10;
                    case "L" -> aryNumb[i] = 50;
                    case "C" -> aryNumb[i] = 100;
                    case "D" -> aryNumb[i] = 500;
                    case "M" -> aryNumb[i] = 1000;
                }

            }
            for (int i = 0; i < aryNumb.length; i++) {
                if (aryNumb[i] < aryNumb[i + 1]) {
                    aryNumb1[i] = aryNumb[i + 1] - aryNumb[i];
                    i++;
                }
            }
            System.out.println(Arrays.toString(aryNumb));
            for (int i = 0; i < aryNumb.length; i++) {
                result += aryNumb1[i];
            }
            return result;
        }
}
