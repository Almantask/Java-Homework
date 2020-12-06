package edu.multithreading.action;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

public class SuperFastCopy {
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



    // Instead of copying files one by one
    // We can copy files simultaniously
    // Simultanious work is done using threads


    // In order to use a thread
    // I need to feed it a Runnable class









    public static void copyFiles(){
        final String in = "target/example/in/";
        final String out = "target/example/out/";
        System.out.println("-------------Started super fast");
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (String file : files) {


            FileCopyTask task = new FileCopyTask(in+"/"+file, out+"/"+file);
            Thread thread = new Thread(task);
            // There is a risks that we won't see all the files
            // Synchronous. One thread await another.
            thread.run();
        }
        System.out.println("-------------Finished super fast?");
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
