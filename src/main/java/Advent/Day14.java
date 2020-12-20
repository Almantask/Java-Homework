package Advent;

import java.util.List;
import java.util.stream.LongStream;

public class Day14 {

    public static void solve(List<String> input) {
        System.out.println(input);
        System.out.println("The answer of Day14 part1 is: " + solvePart1(input));
    }

    private static long solvePart1(List<String> input) {
        long [] addressValues = new long [getMaxAddress(input) + 1];
        String mask = "";
        for (String s : input) {
            if (s.contains("mask")) {
                mask = getMask(s);
                continue;
            }
            int address = Integer.parseInt(getAddressAndBinary(s)[0]);
            String overwrittenBinary = overwrite(mask, getAddressAndBinary(s)[1]);
            addressValues[address] = getDecimal(overwrittenBinary);
        }
        return LongStream.of(addressValues).sum();
    }

    private static String getMask(String mask) {
        return mask.split(" = ")[1];
    }

    private static long getDecimal(String binary) {
        return Long.parseLong(binary, 2);
    }

    private static String overwrite(String mask, String binary) {
        char[] binaryChars = binary.toCharArray();
        char[] maskChars = mask.toCharArray();
        for (int i = 0; i < maskChars.length; i++) {
            switch (maskChars[i]) {
                case '1':
                    binaryChars[i] = '1';
                    break;
                case '0':
                    binaryChars[i] = '0';
                    break;
            }
        }
        return String.valueOf(binaryChars);
    }

    private static String[] getAddressAndBinary(String string) {
        String[] addresAndBinary = new String[2];
        String[] parts = string.split(" = ");
        addresAndBinary[0] = parts[0].replaceAll("[^0-9]", "");
        String toBinary = Integer.toBinaryString(Integer.parseInt(parts[1]));
        addresAndBinary[1] = String.format("%36s", toBinary).replaceAll(" ", "0");
        return addresAndBinary;
    }

    private static int getMaxAddress(List<String> input) {
        int max = 0;
        for (String s : input) {
            if (s.contains("mask"))
                continue;
            int address = Integer.parseInt(getAddressAndBinary(s)[0]);
            if (address > max)
                max = address;
        }
        return max;
    }
}
