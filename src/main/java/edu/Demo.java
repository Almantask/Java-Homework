package edu;

import edu.multithreading.action.*;
import edu.multithreading.result.FileSizezesTotal;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
public class Demo {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        FileCopyTask task = new FileCopyTask(
                "target/example/in/27. Civic Festhall.flac",
                "target/example/out/27. Civic Festhall.flac");
        task.run();
        // Many n files copied.
        // Slower, 1 cpu
        //SlowCopy.copyFiles();
        //SuperFastCopy.copyFiles();
        ActualFast.copyFiles();
//        ManagedCopy.copyFiles();
        //FileSizezesTotal.demoFileSizes();
    }
}
