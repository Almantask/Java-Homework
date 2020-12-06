package edu.action;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

public class SlowCopy {
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

    public static void copyFiles(){
        final String in = "target/example/in/";
        final String out = "target/example/out/";

        System.out.println("-------------Started slow");
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (String file : files) {
                String from = in+"/"+file;
                String to = out+"/"+file;
                Stopwatch sw = Stopwatch.createStarted();
                System.out.println(String.format("Started copying from %s to %s", from, to));

                // Synchronous call- blocks (waits to finish)
                FileCopyTask task = new FileCopyTask(from, to);
                task.run();

                sw.stop();
                System.out.println(String.format("Done copying from %s to %s. Elapsed %d ns", from, to, sw.elapsed(TimeUnit.NANOSECONDS)));
        }
        System.out.println("--------------Finished slow...");
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
