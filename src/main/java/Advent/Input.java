package Advent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    public static List<String> addData() {
        Scanner scanner = new Scanner(System.in);
        List<String> dataList = new ArrayList<>();
        System.out.println("Enter data (at the end write done and press Enter):");

        while (scanner.hasNext()) {
            String i = scanner.next();
            if (i.equals("done")) {
                break;
            }
            dataList.add(i);
        }
        return dataList;
    }

    public static List<String> readFromFile(String path) {
        List<String> dataList = new ArrayList<>();
        try {
            File myFile = new File(path);
            Scanner sc = new Scanner(myFile);
            while (sc.hasNextLine()) {
                dataList.add(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error loading in data");
            e.printStackTrace();
        }
        return dataList;
    }
}
