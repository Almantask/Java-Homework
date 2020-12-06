package edu;

import edu.multithreading.action.ActualFast;
import edu.multithreading.action.ManagedCopy;
import edu.multithreading.action.SlowCopy;
import edu.multithreading.action.SuperFastCopy;
import edu.multithreading.result.FileSizezesTotal;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Demo {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        SlowCopy.copyFiles();
//        SuperFastCopy.copyFiles();
//        ActualFast.copyFiles();
//        ManagedCopy.copyFiles();
        FileSizezesTotal.demoFileSizes();
    }
}
