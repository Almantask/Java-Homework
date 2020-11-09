package Day1;

public class Spacecraft {
    private int numberOfModules;
    private int [] moduleMasses;


    public Spacecraft(int[] moduleMasses) {
        this.moduleMasses = moduleMasses;
        numberOfModules = moduleMasses.length;
    }

    public int getTotalFuelForModules(){
        return totalArrayAmout(getFuelForEachModule());
    }

    public int getTotalFuelForModulesFuel(){
        return totalArrayAmout(getFuelForEachModuleFuel());
    }

    private int totalArrayAmout(int [] array){
        int total = 0;
        for (int i: array) {
            total += i;
        }
        return total;
    }

    private int [] getFuelForEachModule() {
        int [] fuelMasses = new int [numberOfModules];
        for (int i = 0; i < numberOfModules; i++){
            fuelMasses[i] = Fuel(moduleMasses[i]);
        }
        return fuelMasses;
    }

    private int [] getFuelForEachModuleFuel() {
        int [] modulesFuel = getFuelForEachModule();
        int [] fuelMasses = new int[numberOfModules];
        for(int i = 0; i < modulesFuel.length; i++){
            int fuelMass = modulesFuel[i];
            while (Fuel(fuelMass) > 0){
                fuelMass = Fuel(fuelMass);
                fuelMasses[i] += fuelMass;
            }
        }
       return fuelMasses;
    }

    private static int Fuel (int mass){
        return Math.floorDiv(mass, 3) - 2;
    }
}
