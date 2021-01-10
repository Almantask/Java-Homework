package edu.behavioural;

public class WriteTextCommand implements Command{
    private final String text;
    private final Object page;

    public WriteTextCommand(String text, Object page) {
        this.text = text;
        this.page = page;
    }

    @Override
    public void execute() {
        // go to page
        System.out.println(text);
    }

    @Override
    public void undo() {
        // clear text (that was printed
        // go to back to initial page
        System.out.println("Deleting " + text);
    }
}
