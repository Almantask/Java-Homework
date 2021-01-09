package edu.solid;

public class main {
    public static void main(String[] args) {
        File file1 = new File(new FasterButInnaccurateFileReader(), new FasterButInnacurateFileWriter());
        File file2 = new File(new SlowButAccurateFileReader(), new SlowButAccurateFileWriter());
        File file3 = new FastFile();
        // fast write, cause of components
        file1.write("asd");
        // slow write, cause of components
        file2.write("asd");
        file3.write("asd");
    }

}
