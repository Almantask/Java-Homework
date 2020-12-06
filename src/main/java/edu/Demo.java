package edu;

import edu.action.*;
import edu.result.FileSizezesTotal;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
public class Demo {
    public static void main(String[] args) throws Exception {
        FileCopyTask task = new FileCopyTask(
                "target/example/in/27. Civic Festhall.flac",
                "target/example/out/27. Civic Festhall.flac");
        task.run();
        // Many n files copied.
        // Slower, 1 cpu
        //SlowCopy.copyFiles();
        //SuperFastCopy.copyFiles();
        //ActualFast.copyFiles();
        ManagedCopy.copyFiles();

        //2781200
        FileSizezesTotal.demoFileSizesSync();
        //1291100
        FileSizezesTotal.demoFileSizesAsync();
    }
}
