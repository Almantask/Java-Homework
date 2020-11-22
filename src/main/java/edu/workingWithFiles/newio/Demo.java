package edu.workingWithFiles.newio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Demo {
    public static void run() throws IOException {
        System.out.println("------Demo newio------");

        Path path = Paths.get("target/trash.txt");
        Files.delete(path);

        System.out.println("------Demo newio------");
    }
}
