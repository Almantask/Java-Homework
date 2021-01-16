package cpu;

public abstract class ComputerFactory {


    public void assembleComputer(){
        Computer computer = new Computer(selectCase());
        openCase(computer.getCase_());
        plantMotherboard(computer);
        plantRam(computer);
        plantCpu(computer);
        plantGpu(computer);
        closeCase(computer.getCase_());
        installOS(computer);
    }

    protected abstract Case selectCase();
    private void openCase(Case case_){
        System.out.println("Open case");
    }
    protected abstract void plantMotherboard(Computer computer);
    protected abstract void plantRam(Computer computer);
    protected abstract void plantCpu(Computer computer);
    protected abstract void plantGpu(Computer computer);
    private void closeCase(Case case_){
        System.out.println("Close case");
    }
    protected abstract void installOS(Computer computer);
}
