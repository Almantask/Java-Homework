package edu.workingWithFiles.oldio;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {
    /**
     * Create and copies contents from a file in original path, to a file in a new path.
     * @param original - existing file path
     * @param newFile - new file path (might not be existing)
     */
    public static void copy(String original, String newFile) throws IOException {
        BufferedReader in = null;
        BufferedWriter out = null;

        try {
            in = new BufferedReader(new FileReader(original));
            // Add append = ture to buffered writer if you want to update it instead of overwrite
            out = new BufferedWriter(new FileWriter(newFile));

            String line;
            while ((line = in.readLine()) != null) {
                out.write(line + "\r\n");
            }
        }
        // Those are unmanaged resources and they are not handled automatically.
        // You need to take care of them yourself
        // In this case, if we opened a file, we need to close it too in the end
        // regardless of application succeeding or failing (final)
        finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * Deletes a file at path specific
     * @param filePath- indicates a file to delete
     */
    public static void delete(String filePath) throws IOException {
        // converts string to path
        Path path = Paths.get(filePath);
        Files.delete(path);
    }
}
