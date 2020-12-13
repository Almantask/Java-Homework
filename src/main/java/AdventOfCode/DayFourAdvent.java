package AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayFourAdvent {
    public static void main(String[] args) throws FileNotFoundException {
        List<String> file = readFile("passportInfoExample.txt");
        System.out.println(validPassportsPartOne(file));
        System.out.println(validPassportsPartTwo(file));

    }

    public static int validPassportsPartOne(List<String> file) {
        String hcl = null, ecl = null , byr = null , iyr = null , eyr = null, hgt = null , pid = null;
        int validPassports = 0;
        for (int i = 0; i < file.size(); i++) {
            String[] keys = file.get(i).split("[,: ]");
            for (int j = 0; j < keys.length; j += 2) {
                if (keys[j].equals("eyr")) {
                    eyr = keys[j + 1];
                }
                if (keys[j].equals("iyr")) {
                    iyr = keys[j + 1];
                }
                if (keys[j].equals("hcl")) {
                    hcl = keys[j + 1];
                }
                if (keys[j].equals("byr")) {
                    byr = keys[j + 1];
                }
                if (keys[j].equals("ecl")) {
                    ecl = keys[j + 1];
                }
                if (keys[j].equals("hgt")) {
                    hgt = keys[j + 1];
                }
                if (keys[j].equals("pid")) {
                    pid = keys[j + 1];
                }
            }
            if (keys[0].equals("") || i == file.size() - 1) {
                if (byr != null && iyr != null && eyr != null && hgt != null && pid != null && hcl != null && ecl != null) {
                    validPassports++;
                }
                byr = null;
                iyr = null;
                eyr = null;
                hgt = null;
                pid = null;
                hcl = null;
                ecl = null;
            }
        }
        return validPassports;
    }

    public static int validPassportsPartTwo(List<String> file) {
        String hcl = null, ecl = null , byr = null , iyr = null , eyr = null, hgt = null , pid = null;
        int validPassports = 0;
        for (int i = 0; i < file.size(); i++) {
            String[] keys = file.get(i).split("[,: ]");
            for (int j = 0; j < keys.length; j += 2) {
                if (keys[j].equals("eyr")) {
                    eyr = keys[j + 1];
                    if (!(Integer.parseInt(eyr) >= 2020) && !(Integer.parseInt(eyr) <= 2030)) {
                        eyr = null;
                    }
                }
                if (keys[j].equals("iyr")) {
                    iyr = keys[j + 1];
                    if (!(Integer.parseInt(iyr) >= 2010) && !(Integer.parseInt(iyr) <= 2020)) {
                        iyr = null;
                    } else {
                        iyr = keys[j + 1];
                    }
                }
                if (keys[j].equals("hcl")) {
                    if (keys[j+1].startsWith("#") && keys[j+1].matches("[0-9a-f]") && keys[j+1].length() == 7) {
                            hcl = keys[j + 1];
                    } else {hcl = null;}
                }
                if (keys[j].equals("byr")) {
                    byr = keys[j + 1];
                    if (!(Integer.parseInt(byr) >= 1920) && !(Integer.parseInt(byr) <= 2002)) {
                        byr = null;
                    }
                }
                if (keys[j].equals("ecl")) {
                    ecl = keys[j + 1];
                    if (ecl.equals("amb") || ecl.equals("blu") || ecl.equals("brn") || ecl.equals("gry") || ecl.equals("grn") || ecl.equals("hzl")
                    || ecl.equals("oth")) {
                        ecl = keys[j + 1];
                    } else {
                        ecl = null;
                    }
                }
                if (keys[j].equals("hgt")) {
                    hgt = keys[j + 1];
                    String [] numberInString = hgt.split("[cm in]");
                    int number = Integer.parseInt(numberInString[0]);
                    if ((hgt.endsWith("cm") && (number >= 150 && number <= 193)) ||
                            (hgt.endsWith("in") && (number >= 59 && number <= 76))) {
                        hgt = keys[j + 1];
                    } else {
                        hgt = null;
                    }
                }
                if (keys[j].equals("pid")) {
                    pid = keys[j + 1];
                    if (pid.length() == 9) {
                        pid = keys[j + 1];
                    } else
                    pid = null;
                }
            }
            if (keys[0].equals("") || i == file.size() - 1) {
                if (byr != null && iyr != null && eyr != null && hgt != null && pid != null && hcl != null && ecl != null) {
                    validPassports++;
                }
                byr = null;
                iyr = null;
                eyr = null;
                hgt = null;
                pid = null;
                hcl = null;
                ecl = null;
            }
        }
        return validPassports;
    }


    public static List<String> readFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        List<String> tall = new ArrayList<>();
        while (scanner.hasNextLine()) {
            tall.add(scanner.nextLine());
        }
        return tall;
    }
}
