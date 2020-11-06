package Calculator;

public class Arrays {
    public static char [] biggerArray(char[] array){
        char [] biggerArray = new char [array.length+1];
        for (int i = 0; i < array.length; i++){
            biggerArray[i] = array [i];
        }
        return biggerArray;
    }
}
