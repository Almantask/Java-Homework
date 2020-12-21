package Advent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.LongStream;

public class Day14 {

    public static void solve(List<String> input) {
        System.out.println();
        System.out.println("The answer of Day14 part1 is: " + solvePart1(input));
        System.out.println();
        System.out.println("The answer of Day14 part2 is: " + solvePart2(input));
    }

    private static long solvePart2(List<String> input) {
        HashMap<Long, Long> values = new HashMap<>();
        String mask = "";
        for (String s : input) {
            if (s.contains("mask")) {
                mask = getMask(s);
                continue;
            }
            int address = Integer.parseInt(getAddressAndBinary(s)[0]);
            long value = Integer.parseInt(s.split(" = ")[1]);
            for (long i : getChangedAddresses(mask, address))
                values.put(i, value);
        }
        return values.values().stream().reduce( 0l, Long :: sum);
    }

    private static List<Long> getChangedAddresses(String mask, int address) {
        String s = overwriteBinaryPart2(mask, changeToBinary(address));
        int numberOfFloatingBits = s.replaceAll("[^X]", "").length();
        List<Long> newAddresses = new ArrayList<>();
        List<String> combinations = getCombinations(numberOfFloatingBits);
        for (String combination : combinations) {
            char[] chars = combination.toCharArray();
            String newAddress = s;
            for (char ch : chars) {
                newAddress = newAddress.replaceFirst("X", String.valueOf(ch));
                continue;
            }
            newAddresses.add(changeToDecimal(newAddress));
        }
        return newAddresses;
    }

    private static List<String> getCombinations(int numberOfFloatingBits) {
        List<String> bits = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, numberOfFloatingBits); ++i) {
            bits.add(String.format("%" + numberOfFloatingBits + "s", Integer.toBinaryString(i)).replace(" ", "0"));
        }
        return bits;
    }

    private static String overwriteBinaryPart2(String mask, String binary) {
        char[] binaryChars = binary.toCharArray();
        char[] maskChars = mask.toCharArray();
        for (int i = 0; i < maskChars.length; i++) {
            switch (maskChars[i]) {
                case '1':
                    binaryChars[i] = '1';
                    break;
                case 'X':
                    binaryChars[i] = 'X';
                    break;
            }
        }
        return String.valueOf(binaryChars);


    }

    private static String changeToBinary(int address) {
        return String.format("%36s", Integer.toBinaryString(address)).replaceAll(" ", "0");
    }

    private static long solvePart1(List<String> input) {
        long[] addressValues = new long[getMaxAddress(input) + 1];
        String mask = "";
        for (String s : input) {
            if (s.contains("mask")) {
                mask = getMask(s);
                continue;
            }
            int address = Integer.parseInt(getAddressAndBinary(s)[0]);
            String overwrittenBinary = overwriteBinaryByMask(mask, getAddressAndBinary(s)[1]);
            addressValues[address] = changeToDecimal(overwrittenBinary);
        }
        return LongStream.of(addressValues).sum();
    }

    private static String getMask(String mask) {
        return mask.split(" = ")[1];
    }

    private static long changeToDecimal(String binary) {
        return Long.parseLong(binary, 2);
    }

    private static String overwriteBinaryByMask(String mask, String binary) {
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
        String[] addressAndBinary = new String[2];
        String[] parts = string.split(" = ");
        addressAndBinary[0] = parts[0].replaceAll("[^0-9]", "");
        String toBinary = Integer.toBinaryString(Integer.parseInt(parts[1]));
        addressAndBinary[1] = String.format("%36s", toBinary).replaceAll(" ", "0");
        return addressAndBinary;
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
