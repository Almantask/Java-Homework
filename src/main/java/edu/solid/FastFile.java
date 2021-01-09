package edu.solid;

public class FastFile extends File {
    public FastFile() {
        super(new FasterButInnaccurateFileReader(), new FasterButInnacurateFileWriter());
    }
}
