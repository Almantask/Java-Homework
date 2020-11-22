package edu.protectedkeywordAndEnum;

/*
1 TSP = 5 ML
1 TBSP = 15 ML
1 FL OUNCE = 30 ML
1 CUP = 237 ML
1 PINT (2 CUPS) = 473 ML
1 QUART (4 CUPS) = .95 LITER
1 GALLON (16 CUPS) = 3.8 LITERS
1 OZ = 28 GRAMS
1 POUND = 454 GRAMS
 */

public enum Unit {
    TSP(5),
    TBSP(15),
    FL_OUNCE(30),
    CUP(237);

    private final int ml;

    // What's the point of making this public
    // All the values should be set in stone
    // It's a constant after all.
    Unit(int ml){
        this.ml = ml;
        System.out.println("enum was created " + ml);
    }

    public int getMl(){
        return ml;
    }
}
