package RocketEquation;

public class RocketEquation {

    public static void main(String[] args) {
        System.out.println("Needed fuel: " + neededMass(moduleMass));
        System.out.println("Needed fuel with additional fuel: " + neededAdditionalMass(moduleMass));

    }

        public static long[] moduleMass = {56123, 145192, 123702, 66722, 148748, 53337, 147279, 126828, 118438, 54030,
                145839, 87751, 58832, 90085, 113196, 104802, 61235, 136935, 108620, 60795, 107908, 123023, 142399, 131074, 123411, 122653, 84776,
                100891, 78816, 62762, 92077, 91428, 56831, 65122, 94694, 78668, 112506, 73406, 118239, 57897, 59200, 54437, 55185, 102667, 86076,
                80655, 83406, 141502, 67171, 88472, 149260, 68395, 56828, 108798, 125682, 68203, 118263, 101824, 94853, 68536, 95646, 120283, 135355,
                82701, 92243, 122282, 55760, 129959, 142814, 56599, 70836, 69996, 85262, 126648, 69043, 67460, 119934, 82453, 147012, 72957, 53374,
                97577, 59696, 121630, 122666, 116591, 145967, 75699, 85963, 140970, 75612, 78792, 100795, 92034, 132569, 117172, 134179, 109504, 103707,
                54664,
        };

        public static long neededMass (long [] array) {
            long sumOfMass = 0;
            for (long l : array) {
                long oneModule = (l / 3 - 2);
                sumOfMass += oneModule;
            }
            return sumOfMass;
    }


        public static long neededAdditionalMass (long [] array) {
            long sumOfMass = 0;
            for (long l : array) {
                long oneModule = (l / 3 - 2);
                oneModule = neededAdditionalMass(oneModule);
                sumOfMass += oneModule;
            }
            return sumOfMass;
        }

        private static long neededAdditionalMass (long number) {
            long numberOne = number;
            long sumOfOne = 0;
            while (number > 0) {

                number = (number / 3 - 2);
                if (number < 0) {
                    continue;
                }
                sumOfOne += number;
            }
            return sumOfOne + numberOne;
        }

    }

