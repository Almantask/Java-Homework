package AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayTwoAdvent {

    public static void main(String[] args) throws FileNotFoundException {
        List<String> passwords = readFile("passwords.txt");
        System.out.println(findCorrectPassword(passwords));
        System.out.println(findCorrectPasswordTwo(passwords));
    }

    public static int findCorrectPassword(List<String> passwords) {
        int from, to;
        int correctPasswords = 0;
        for (int i = 0; i<passwords.size(); i += 1) {
            String [] numbers = passwords.get(i).split("[a-z-,: ]");
            String [] requirement = passwords.get(i).split("[:0-9- ]");
            from = Integer.parseInt(numbers[0]) - 1;
            to = Integer.parseInt(numbers[1]);
            char requiredLetter = requirement[requirement.length -3].charAt(0);
            String password = requirement[requirement.length - 1];
            if (findAllSameLetters(password, requiredLetter) > from && findAllSameLetters(password,requiredLetter) <= to) {
                correctPasswords++;
            }
        }
        return correctPasswords;
    }
    public static int findCorrectPasswordTwo(List<String> passwords) {
        int from, to;
        int correctPasswords = 0;
        for (int i = 0; i<passwords.size(); i += 1) {
            String[] numbers = passwords.get(i).split("[a-z-,: ]");
            String[] requirement = passwords.get(i).split("[:0-9- ]");
            from = Integer.parseInt(numbers[0]);
            to = Integer.parseInt(numbers[1]);
            char requiredLetter = requirement[requirement.length - 3].charAt(0);
            String password = requirement[requirement.length - 1];
            try {
                if ((password.charAt(from - 1) == requiredLetter && password.charAt(to - 1) != requiredLetter)
                        || (password.charAt(from - 1) != requiredLetter && password.charAt(to - 1) == requiredLetter)) {
                    correctPasswords++;
                }
            } catch (StringIndexOutOfBoundsException e) {
                    if (password.charAt(from + 1) == requiredLetter)
                        correctPasswords++;
            }
        }
        return correctPasswords;
    }

    public static List<String> readFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        List<String> tall = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            tall.add(scanner.nextLine());
        }
        return tall;
    }

    public static int findAllSameLetters (String someString, char someChar ) {
        int count = 0;
        for (int i = 0; i < someString.length(); i++) {
            if (someString.charAt(i) == someChar) {
                count++;
            }
        }
        return count;
    }

}
