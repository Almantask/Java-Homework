package edu;

public class Demo {
    public static void main(String[] args) {
        ProgressBar bar = new ProgressBar(0, 100);
        for (int i = 0; i < 100; i++) {
            bar.addProgress(1);
            clearScreen();
            System.out.println(bar);
        }
    }

    // TODO: figure out how to clear a console
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
