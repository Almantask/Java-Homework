package cpu;

public abstract class Computer {
    public void assembleComputer(){
        selectCase();
        openCase();
        plantMotherboard();
        plantRam();
        plantCpu();
        plantGpu();
        closeCase();
        installOS();
    }

    abstract void selectCase();
    public void openCase(){
        System.out.println("Open case");
    }
    abstract void plantMotherboard();
    abstract void plantRam();
    abstract void plantCpu();
    abstract void plantGpu();
    public void closeCase(){
        System.out.println("Close case");
    }
    abstract void installOS();
}
