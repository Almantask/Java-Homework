package Calendar1;

public class Cal1 {
   public static int calculate(int [] a){
       int result = 0;
       for(int i = 0; i < a.length; i++){
          result += ((int) ((Math.ceil(a[i] / 3))) - 2);
       }
       return result;
   }
}
