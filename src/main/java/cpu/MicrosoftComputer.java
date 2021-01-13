package cpu;

public class MicrosoftComputer extends Computer{
    @Override
    void selectCase() {
        System.out.println("Select Microsoft case");
    }

    @Override
    void plantMotherboard() {
        System.out.println("Plant Microsoft motherboard");
    }

    @Override
    void plantRam() {
        System.out.println("Plant Microsoft ram");
    }

    @Override
    void plantCpu() {
        System.out.println("Plant Microsoft cpu");
    }

    @Override
    void plantGpu() {
        System.out.println("Plant Microsoft gpu");
    }

    @Override
    void installOS() {
        System.out.println("Install Microsoft OS");
    }
}
