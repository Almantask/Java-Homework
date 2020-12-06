package edu.result;

import com.google.common.base.Stopwatch;

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

    public static void demoFileSizesSync() throws Exception {
        final String in = "target/example/in/";

        System.out.println("-------------Started get total files size");
        Stopwatch stopwatch = Stopwatch.createStarted();
        Double total = 0d;
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            GetFileSizeTask task = new GetFileSizeTask(in + "/" + file);
            Double res = task.call();
            System.out.println(res);
            total += res;
        }
        System.out.println("-----------Finished! Total: " + total + "kb");
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.NANOSECONDS));
    }

    public static void demoFileSizesAsync() throws InterruptedException, ExecutionException {
        final String in = "target/example/in/";

        System.out.println("-------------Started get total files size");
        Stopwatch stopwatch = Stopwatch.createStarted();
        ExecutorService es = Executors.newFixedThreadPool(100);
        // in the future, results will be retrieved.
        // A kind of thread which holds a results in itself.
        Future<Double>[] results = new Future[files.length];
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            GetFileSizeTask task = new GetFileSizeTask(in + "/" + file);
            // Start work
            results[i] = es.submit(task);
        }

        // 10, 9, 5, 7, 16
        // (sync total = 47ms)
        // returns 50kb after 10ms
        // returns 44kb after 0ms
        // returns 20kb after 0ms
        // returns 33kb after 0ms
        // returns 100kb after 6ms
        // (async total 16).

        // waits for results
        Double total = 0d;
        for(Future<Double> result : results){
            // synchronizing...
            // Get results
            // Just like join
            Double res = result.get();
            System.out.println(res);
            total += res;
        }

        System.out.println("-----------Finished! Total: " + total + "kb");
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.NANOSECONDS));
    }
}
