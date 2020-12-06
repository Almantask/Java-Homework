package edu.multithreading.result;

import java.io.File;
import java.util.concurrent.Callable;

public class GetFileSizeTask implements Callable<Double> {
    private final String file;

    public GetFileSizeTask(String file) {
        this.file = file;
    }

    @Override
    public Double call() throws Exception {
        // kb
        return (double) new File(file).length() / 1024;
    }
}
