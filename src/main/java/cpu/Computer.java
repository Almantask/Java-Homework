package cpu;

public class Computer {
    private Case case_;
    private Motherboard motherboard;
    private CPU cpu;
    private GPU gpu;
    private Ram ram;
    private OS os;

    /**
     * Every computer must has a case. Even an empty case is considered as computer.
     */
    public Computer(Case case_) {
        this.case_ = case_;
    }

    public Case getCase_() {
        return case_;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public GPU getGpu() {
        return gpu;
    }

    public void setGpu(GPU gpu) {
        this.gpu = gpu;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    public void setOs(OS os) {
        this.os = os;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }
}
