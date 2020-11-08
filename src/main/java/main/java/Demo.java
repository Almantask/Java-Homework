package main.java;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Fuel array: " + Arrays.toString(sumOfFuel(mass)));
    }

    public static int[] mass = {66910, 78957, 58510,142350, 105820, 87317, 100743, 51390, 92804, 80752, 70169, 111892, 104715,
            143166, 126158, 78712, 139223, 133863, 85912, 53883, 64812, 102254, 52482, 91855, 117520, 140253, 76706, 106693,
            57948, 57578, 115640, 131273, 115373, 145219, 100889, 106447, 72347, 120250, 56898, 146689, 138246, 85068, 55292,
            124814, 136750, 51820, 70396, 92806, 86093, 70467, 122356, 148530, 85569, 100492, 87062, 123225, 73872, 102104, 91194,
            95077, 88352, 114906, 141056, 87220, 106517, 88867, 95883, 130158, 76702, 134241, 50561, 119258, 61669, 140396, 145201,
            76914, 102281, 56618, 145968, 99542, 116789, 135633, 114646, 84253, 50650, 69127, 95446, 55357, 81180, 126940, 133743,
            52261, 117429, 82291, 110373, 67626, 58014, 125342, 129508, 96332
    };

    public static int[] sumOfFuel(int[] mass) {
        int[] array = new int[mass.length];

        for (int i = 0; i < mass.length; i++) {
            array[i] = (int) Math.floor(mass[i] / 3 - 2);
            int sum = IntStream.of(array).sum();

            //Prints sum of fuel only 1 time.
            if (i == array.length - 1)
            {
                System.out.println("The sum of fuel: " + sum);
            }
        }
        return array;
    }
}
