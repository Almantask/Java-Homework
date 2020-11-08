package Numbers;

public class PrimeNumbers {
    public static int[] findAll(int rangeEnd) {
        int[] numbers = new int[0];
        for(int n = 2; n <= rangeEnd; n++){
            if(isPrime(n)){
                numbers = addNumber(numbers, n);
            }
        }

        return numbers;
    }

    public static boolean isPrime(int n){
        for(int i = 2; i < n / 2 + 1; i++){
            if(n % i == 0){
                return false;
            }
        }

        return true;
    }

    private static int[] addNumber(int[] numbers, int n){
        int[] withExtra = new int[numbers.length+1];
        for (int i = 0; i < numbers.length; i++){
            withExtra[i] = numbers[i];
        }

        withExtra[withExtra.length-1] = n;

        return withExtra;
    }
}
