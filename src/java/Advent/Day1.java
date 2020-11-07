import Advent.FileUtil;

import java.util.List;

public class Day1 {

    public static void main(String[] args) {

        List<String> input;
        input = FileUtil.loadFile("src/java/Advent/day1");
        int sum = 0;
        for (String s : input) {


            int mass = Integer.parseInt(s);
            //part2
            while (mass > 0) {
                int result = (mass / 3) - 2;
                if (result > 0)
            sum += result;
                mass = result;

        }
        }
            System.out.println(sum);
        }
    }

