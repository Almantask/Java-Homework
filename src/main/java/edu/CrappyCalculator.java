package edu;

public class CrappyCalculator {
    private String display = "";

    public String getDisplay() {
        return display;
    }

    public void add(){
        display+="+";
    }

    public void minus(){
        display+="-";
    }

    public void number(int number){
        if (number != 0 || !display.isEmpty()) {
            display+=number;
        }
    }

    public void equal(){
        boolean isPlus = false;
        boolean isMinus = false;
        if(display.contains("+")) {
            isPlus = true;
        }
        else if(display.contains("-")){
            isMinus = true;
        }

        String[] operands = display.split("[-+]");
        Integer number1 = Integer.parseInt(operands[0]);

        if(operands.length != 2){
            display = number1.toString();
            return;
        }

        Integer number2 = Integer.parseInt(operands[1]);
        if(isPlus){
            Integer result = (number1 + number2);
            display = result.toString();
        }
        else if(isMinus){
            Integer result = (number1 - number2);
            display = result.toString();
        }
        else{
            display = "error";
        }
    }

    public void div(){
        throw new RuntimeException("Div is not implemented");
    }

    public void reset() {
        display = "";
    }
}
