public class Helper {

    public static int factorial(int number) {
        // comment for new commit...
        int factorial = 1;
        for (int i = 1; i < number + 1; i++) {
            factorial *= i;
        }
        return factorial;
    }

}
