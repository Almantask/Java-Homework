package edu.workingWithFiles.oldio;

import java.io.IOException;

// java.io is old
// java.io is slow (blocking)
public class Demo {
    public static void run() throws IOException {
        System.out.println("------Demo oldio------");

        FileUtils.copy("target/testing.txt", "target/testing-copy.txt");
        FileUtils.delete("target/testing-copy.txt");

        System.out.println("------Demo oldio------");
    }



    // FileInputStream, FileOutputStream is slow
    //
}
