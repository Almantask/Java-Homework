package edu;

import edu.multithreading.action.*;
import edu.multithreading.result.FileSizezesTotal;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Demo {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        FileCopyTask task = new FileCopyTask("target/example/in/DnD Commission Dwarf Cleric of Moradin.png","target/example/out/DnD Commission Dwarf Cleric of Moradin.png");
        //SlowCopy.copyFiles();
//        SuperFastCopy.copyFiles();
//        ActualFast.copyFiles();
//        ManagedCopy.copyFiles();
        //FileSizezesTotal.demoFileSizes();
    }
}
