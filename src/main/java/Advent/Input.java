package Advent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    public static List addData() {
        Scanner scanner = new Scanner(System.in);
        ArrayList codeList = new ArrayList();
        System.out.println("Enter data (at the end write done and press Enter):");

        while (scanner.hasNext()) {
            String i = scanner.next();
            if (i.equals("done")) {
                break;
            }
            codeList.add(i);
        }
        return codeList;
    }
}
