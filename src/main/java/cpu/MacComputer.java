package cpu;

public class MacComputer extends Computer{
    @Override
    void selectCase() {
        System.out.println("Select Mac case");
    }

    @Override
    void plantMotherboard() {
        System.out.println("Plant Mac motherboard");
    }

    @Override
    void plantRam() {
        System.out.println("Plant Mac ram");
    }

    @Override
    void plantCpu() {
        System.out.println("Plant Mac cpu");
    }

    @Override
    void plantGpu() {
        System.out.println("Plant Mac gpu");
    }

    @Override
    void installOS() {
        System.out.println("Install Mac OS");
    }
}
