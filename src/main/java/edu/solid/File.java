package edu.solid;

public final class File {
    private final Reader reader;
    private final Writer writer;

    public File(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public final String read(){
        return reader.read();
    }

    public final void write(String text){
        writer.write(text);
    }
}
