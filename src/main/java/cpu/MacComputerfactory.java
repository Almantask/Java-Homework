package cpu;

public class MacComputerfactory extends ComputerFactory {

    @Override
    protected Case selectCase() {
        return new Case();
    }

    @Override
    protected void plantMotherboard(Computer computer) {
        Motherboard motherboard = new Motherboard();
        computer.setMotherboard(motherboard);
    }

    @Override
    protected void plantRam(Computer computer) {
        Ram ram = new Ram();
        computer.setRam(ram);
    }

    @Override
    protected void plantCpu(Computer computer) {
        CPU cpu = new CPU();
        computer.setCpu(cpu);
    }

    @Override
    protected void plantGpu(Computer computer) {
        GPU gpu = new GPU();
        computer.setGpu(gpu);
    }

    @Override
    protected void installOS(Computer computer) {
        OS os = new OS();
        computer.setOs(os);
    }

}
