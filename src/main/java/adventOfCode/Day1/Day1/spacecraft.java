package adventOfCode.Day1.Day1;

public class spacecraft {

    public static int getFuelRequirementsForOneModule(int moduleMass) {
        int fuelRequirementsForOneModule = moduleMass / 3 - 2;
        return fuelRequirementsForOneModule;
    }

    public static int getFuelRequirementsForAllModules(int[] moduleMass) {
        int fuelRequirementsForAllModules = 0;
        int fuelRequirementsForOneModule = 0;
        for (int i = 0; i < moduleMass.length; i++) {
            fuelRequirementsForOneModule = getFuelRequirementsForOneModule(moduleMass[i]);
            fuelRequirementsForAllModules += fuelRequirementsForOneModule;
        }
        return fuelRequirementsForAllModules;
    }

    public static int getFuelForModuleWithFuel(int moduleMass) {
        int fuelForModuleWithFuel = 0;
        int[] fuel = new int[1];
        fuel[0] = moduleMass / 3 - 2;
        for (int i = 0; fuel[i] > 0; i++) {
            if (fuel[i] / 3 - 2 <= 0) {
                break;
            }
            fuel = addNumber(fuel, fuel[i] / 3 - 2);
        }
        for (int i = 0; i < fuel.length; i++) {
            fuelForModuleWithFuel += fuel[i];
        }
        return fuelForModuleWithFuel;
    }

    public static int getTotalFuelForAllModules(int[] moduleMass) {
        int totalFuelForAllModules = 0;
        int fuelForModuleWithFuel = 0;
        for (int i = 0; i < moduleMass.length; i++) {
            fuelForModuleWithFuel = getFuelForModuleWithFuel(moduleMass[i]);
            totalFuelForAllModules += fuelForModuleWithFuel;
        }
        return totalFuelForAllModules;
    }

    private static int[] addNumber(int[] numbers, int n) {
        int[] withExtra = new int[numbers.length + 1];
        for (int i = 0; i < numbers.length; i++) {
            withExtra[i] = numbers[i];
        }

        withExtra[withExtra.length - 1] = n;

        return withExtra;
    }
}