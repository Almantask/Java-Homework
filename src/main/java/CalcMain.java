public class CalcMain {

    public static void main(String[] args) {

        Calculator calc = new Calculator();
        System.out.println(calc.calculate("5+5"));
        System.out.println(calc.calculate("5-5"));
        System.out.println(calc.calculate("5*5"));
        System.out.println(calc.calculate("5/5"));
        System.out.println(calc.calculate("5%5"));
        System.out.println(calc.calculate("5/0"));
        System.out.println(calc.calculate("5!"));
        System.out.println(calc.calculate("5*1+2-4!"));
        System.out.println(calc.calculate("5.57*1+2-4!"));
    }
}
