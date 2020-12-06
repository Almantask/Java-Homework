package Day1;

public class Day1 {
    public static int MultiplyingEntries (int[] expenseReport){
        int multiplying = 0;

        for(int i=0; i<expenseReport.length-1; i++) {
            for (int j = 1; j < expenseReport.length; j++){
                if(expenseReport(i) + expenseReport(j) = 2020){
                    multiplying = expenseReport(i) * expenseReport(j);
                }
            }
        }
        return multiplying;
    }

}


//Specifically, they need you to find the two entries that sum to 2020 and then multiply
// those two numbers together.
//For example, suppose your expense report contained the following:
//1721
//979
//366
//299
//675
//1456
//In this list, the two entries that sum to 2020 are 1721 and 299. Multiplying them
// together produces 1721 * 299 = 514579, so the correct answer is 514579.
//
//Of course, your expense report is much larger. Find the two entries that sum to 2020;
// what do you get if you multiply them together?