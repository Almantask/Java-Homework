package edu.multithreading.result;

import com.google.common.base.Stopwatch;
import edu.multithreading.action.FileCopyTask;

import java.util.concurrent.*;

public class FileSizezesTotal {
    private static final String[] files = {
            "DnD Commission Dwarf Cleric of Moradin.png",
            "Dwarf.PNG",
            "input.txt",
            "Prosthetics3.png",
            "Words.txt",
            "08. Fall-From-Grace Theme.flac",
            "03. Deionarra Theme.flac",
            "05. Annah Theme.flac",
            "27. Civic Festhall.flac"
    };

    public static void demoFileSizes() throws InterruptedException, ExecutionException {
        final String in = "target/example/in/";

        System.out.println("-------------Started get total files size");
        Stopwatch stopwatch = Stopwatch.createStarted();
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<Double>[] results = new Future[files.length];
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            GetFileSizeTask task = new GetFileSizeTask(in + "/" + file);
            results[i] = es.submit(task);
        }

        // waits for results
        Double total = 0d;
        for(Future<Double> result : results){
            Double res = result.get();
            System.out.println(res);
            total += res;
        }

        System.out.println("-----------Finished! Total: " + total + "kb");
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
