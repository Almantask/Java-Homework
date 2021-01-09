package edu.designpatterns.creational;

public class PrinterBuilder {
    double calculatePrice(double price, String vatKind, String country){
        double taxRatio = 1;
        if(country.equals("Austria")){
            if(vatKind.equals("Standard")){
                taxRatio = 1.20;
            }
            else if(vatKind.equals("Reduced1")){
                taxRatio = 1.13;
            }
            else if(vatKind.equals("Reduced2")){
                taxRatio = 1.10;
            }
            else if(vatKind.equals("Zero")){
                taxRatio = 1.00;
            }
        }
        else if(country.equals("Belgium")){
            if(vatKind.equals("Standard")){
                taxRatio = 1.21;
            }
            else if(vatKind.equals("Reduced1")){
                taxRatio = 1.12;
            }
            else if(vatKind.equals("Reduced2")){
                taxRatio = 1.06;
            }
            else if(vatKind.equals("Zero")){
                taxRatio = 1.00;
            }
        }
        else if(country.equals("Bulgaria")){
            if(vatKind.equals("Standard")){
                taxRatio = 1.20;
            }
            else if(vatKind.equals("Reduced1")){
                taxRatio = 1.09;
            }
            else if(vatKind.equals("Reduced2")){
                taxRatio = 1.09;
            }
            else if(vatKind.equals("Reduced")){
                taxRatio = 1.09;
            }
            else if(vatKind.equals("Zero")){
                taxRatio = 1.00;
            }
        }
        else if(country.equals("Lithuania")){
            if(vatKind.equals("Standard")){
                taxRatio = 1.20;
            }
            else if(vatKind.equals("Reduced1")){
                taxRatio = 1.09;
            }
            else if(vatKind.equals("Reduced2")){
                taxRatio = 1.05;
            }
            else if(vatKind.equals("Zero")){
                taxRatio = 1.00;
            }
        }

        return price * taxRatio;
    }
}
