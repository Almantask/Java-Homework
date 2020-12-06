package edu.multithreading.action;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

public class ActualFast {
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

        System.out.println("-------------Started actual fast");
        Stopwatch stopwatch = Stopwatch.createStarted();
        Thread[] threads = new Thread[files.length];
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            FileCopyTask task = new FileCopyTask(in + "/" + file, out + "/" + file);
            Thread thread = new Thread(task);
            threads[i] = thread;
            thread.start();
        }

        // What if we have 1000 files?
        // Wait for results
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Finished actual fast!");
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
