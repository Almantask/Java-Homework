package cpu;

public class Main {
    public static void main(String[] args) {
        MicrosoftComputer msCpu = new MicrosoftComputer();
        msCpu.assembleComputer();
        MacComputer macCpu = new MacComputer();
        macCpu.assembleComputer();
    }
}
