package edu.multithreading.action;

import com.google.common.base.Stopwatch;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

// runnable interface
// a task
// can run
public class FileCopyTask implements Runnable {
    private final String from;
    private final String to;

    // All that we need needs to passed through ctor
    public FileCopyTask(String from, String to) {
        this.from = from;
        this.to = to;
    }

    // Any work that happens on the thread
    // Is now a responsibility of it to handle errors.
    @Override
    public void run() {
        try {
            Stopwatch sw = Stopwatch.createStarted();
            System.out.println(String.format("Started copying from %s to %s", from, to));
            FileUtils.copyFile(new File(from), new File(to));
            sw.stop();
            System.out.println(String.format("Done copying from %s to %s. Elapsed %d ns", from, to, sw.elapsed(TimeUnit.NANOSECONDS)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
