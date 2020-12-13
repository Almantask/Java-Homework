package Advent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Day4 {

    public static int solveDay4(List input) {
        List passports = rewriteList(input);
        int sumValidPassports = 0;
        for (Object s : passports) {
            if (validation(s)) {
                if (validation2(s)) {
                    sumValidPassports += 1;
                }
            }
        }
        return sumValidPassports;
    }

    private static boolean validation(Object s) {

        return s.toString().contains("byr") && //byr (Birth Year)
                s.toString().contains("iyr") && //iyr (Issue Year)
                s.toString().contains("eyr") && //eyr (Expiration Year)
                s.toString().contains("hgt") && //hgt (Height)
                s.toString().contains("hcl") && //hcl (Hair Color)
                s.toString().contains("ecl") && //ecl (Eye Color)
                s.toString().contains("pid"); //pid (Passport ID)
    }

    private static boolean validation2(Object s) {
        List passportFields = new ArrayList(Arrays.asList(s.toString().split("[,; \t\n\r]+")));
        HashMap<String, String> fields = new HashMap<String, String>();
        for (Object passportField : passportFields) {
            String o = passportField.toString();
            String[] array = o.split(":");
            if (array.length < 2) {
                continue;
            }
            fields.put(array[0], array[1]);
        }
        int byr = Integer.parseInt(fields.get("byr"));
        int iyr = Integer.parseInt(fields.get("iyr"));
        int eyr = Integer.parseInt(fields.get("eyr"));
        String hgt = fields.get("hgt");
        String hcl = fields.get("hcl");
        String ecl = fields.get("ecl");
        String pid = fields.get("pid");

        return (byr >= 1920 && byr <= 2002) &&
                (iyr >= 2010 && iyr <= 2020) &&
                (eyr >= 2020 && eyr <= 2030) &&
                heightValidation(hgt) &&
                hcl.length() == 7 &&
                eyeColor(ecl) &&
                pid.length() == 9;
    }

    public static boolean heightValidation (String height) {
        if (height.contains("cm")) {
            int hgt = Integer.parseInt(height.replace("cm", ""));
            return hgt >= 150 && hgt  <= 193;
        } else
            if(height.contains("in")) {
                int hgt = Integer.parseInt(height.replace("in", ""));
                return hgt >= 59 && hgt <= 76;
            }
    return false;
    }

    public static boolean eyeColor(String string) {
        return string.equals("amb") ||
                string.equals("blu") ||
                string.equals("brn") ||
                string.equals("gry") ||
                string.equals("grn") ||
                string.equals("hzl") ||
                string.equals("oth");
    }

    public static List<String> rewriteList(List list) {
        String listString = "";
        for (Object o : list) {
            if (!o.equals("")) {
            } else {
                o = ",";
            }
            listString += o + "\t";
        }
        List<String> rewrited = Arrays.asList(listString.split(","));
        return rewrited;
    }
}
