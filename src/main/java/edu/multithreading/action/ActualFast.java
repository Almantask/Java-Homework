package edu.multithreading.action;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

public class ActualFast {
    private static final String[] files = {
            "27. Civic Festhall.flac",
            "DnD Commission Dwarf Cleric of Moradin.png",
            "Dwarf.PNG",
            "input.txt",
            "Prosthetics3.png",
            "Words.txt",
            "08. Fall-From-Grace Theme.flac",
            "03. Deionarra Theme.flac",
            "05. Annah Theme.flac"
    };

    public static void copyFiles() throws InterruptedException {
        final String in = "target/example/in/";
        final String out = "target/example/out/";

        System.out.println("-------------Started actual fast");
        Stopwatch stopwatch = Stopwatch.createStarted();
        Thread[] threads = new Thread[files.length];
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            FileCopyTask task = new FileCopyTask(in + "/" + file, out + "/" + file);
            Thread thread = new Thread(task);
            threads[i] = thread;
            // Start method will finish running in the thread.join place
            // Asynchronous
            thread.start();
        }

        // 10, 5, 1, 5, 16, 9


        // Wait till all threads finish running
        for (int i = 0; i < threads.length; i++) {
            Thread thread = threads[i];
            Stopwatch stopwatch2 = Stopwatch.createStarted();
            // Wait till thread finishes running
            // Synchronizing...
            thread.join();
            stopwatch2.stop();
            System.out.println(String.format("Thread %d took %dms", i, stopwatch2.elapsed(TimeUnit.MILLISECONDS)));
        }

        // Synchronous- do one job at the time.
        // Swimmer1 started and finished in 5s.
        // Swimmer2 started and finished in 6s.
        // Referee waited 11s total.

        // Multithreaded
        // Swimmer1 and two both started at the same time.
        // Swimmer1 finished in 5s, then swimmer2 finished in 6s.
        // Referee waited 6s.

        // Parallel- a kind of multithreading - do the same job simultaniously. CPU-intense, heavy load.
        // Multiple files being processed simultaniously
        // I do work
        // My CPU is potentially at 100%.

        // Async- a kind of multithreading - call the same thing simultaniously. I/O-bound, waiting mostly, does little.
        // Multiple requests sent. Waiting for responses.
        // I wait others to do work.
        // My CPU is potentially at 1% or less.

        System.out.println("Finished actual fast!");
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
