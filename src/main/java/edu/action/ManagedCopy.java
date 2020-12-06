package edu.action;

import com.google.common.base.Stopwatch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ManagedCopy {
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

    public static void copyFiles() throws InterruptedException {
        final String in = "target/example/in/";
        final String out = "target/example/out/";

        System.out.println("-------------Managed");
        Stopwatch stopwatch = Stopwatch.createStarted();
        // Like a brigade of workers
        // That's the way to do it.
        ExecutorService es = Executors.newFixedThreadPool(100);
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            FileCopyTask task = new FileCopyTask(in + "/" + file, out + "/" + file);
            // Work submitted for a brigade.
            es.submit(task);
        }

        // signed contract, no more work will be accepted.
        es.shutdown();
        // wait for results.
        // join equivalent
        // Waiting for workers to do their job.
        // No more than 1 second.
        es.awaitTermination(1, TimeUnit.SECONDS);

        System.out.println("Finished managed");
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
