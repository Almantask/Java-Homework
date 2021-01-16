package cpu;

public class Main {
    public static void main(String[] args) {
        MicrosoftComputerFactory msCpu = new MicrosoftComputerFactory();
        msCpu.assembleComputer();
        MacComputerfactory macCpu = new MacComputerfactory();
        macCpu.assembleComputer();
    }
}
