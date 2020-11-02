import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public int calculate(String s) {
        // comment for new commit...

        ArrayList<String> factorials = new ArrayList<String>();
        ArrayList<String> finalString = new ArrayList<String>();
        int result = 0;


        if (s.equals(null) || !s.isEmpty()) {

            Pattern pattern = Pattern.compile("[1-9]*!");
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                String sign = matcher.group();
                String replacement = "@";
                s = s.replace(sign, replacement);
                String temp = sign.replace("!", "");
                factorials.add(temp);
            }

            String[] stringArray = s.split("(?<=[-+x%@])|(?=[-+x%@])");

            for (int i = 0; i < stringArray.length; i++) {
                if (stringArray[i].equals("x")) {

                    int tempInt = Integer.parseInt(stringArray[i - 1]) * Integer.parseInt(stringArray[i + 1]);
                    String tempString = String.valueOf(tempInt);
                    s = s.replace((stringArray[i - 1] + stringArray[i] + stringArray[i + 1]), tempString);
                } else if (stringArray[i].equals("%")) {

                    int tempInt1 = (Integer.parseInt(stringArray[i - 1]) / Integer.parseInt(stringArray[i + 1]));
                    String tempString1 = String.valueOf(tempInt1);
                    s = s.replace(stringArray[i - 1] + stringArray[i] + stringArray[i + 1], tempString1);

                }

            }

            stringArray = s.split("(?<=[-+x%@])|(?=[-+x%@])");
            int f = 0;
            for (int i = 0; i < stringArray.length; i++) {
                finalString.add(stringArray[i]);

                if (stringArray[i].equals("@")) {
                    int temp = Helper.factorial(Integer.parseInt(factorials.get(f)));
                    f++;
                    String tempString = String.valueOf(temp);
                    finalString.set(i, tempString);

                }
            }
            for (int i = 0; i < finalString.size(); i++) {

                if (finalString.get(i).equals("-")) {

                    int tempInt = Integer.parseInt(finalString.get(i - 1)) - Integer.parseInt(finalString.get(i + 1));
                    result = tempInt;
                    finalString.set(i - 1, String.valueOf(tempInt));
                    finalString.remove(i);
                    finalString.remove(i);
                    i = 0;

                } else if (finalString.get(i).equals("+")) {

                    int tempInt1 = Integer.parseInt(finalString.get(i - 1)) + Integer.parseInt(finalString.get(i + 1));
                    result = tempInt1;
                    finalString.set(i - 1, String.valueOf(tempInt1));
                    finalString.remove(i);
                    finalString.remove(i);
                    i = 0;

                }
            }


        } else {
            return 0;
        }
        return result;
    }

}
