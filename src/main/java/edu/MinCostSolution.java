package edu;

public class MinCostSolution {


    private int[] cost;
    private String s;
    private String[] stringResult;



    public MinCostSolution(String s, int[] cost){

        this.cost = cost;
        this.stringResult = s.split("");
    }

    public int[] getCost() {
        return cost;
    }

    public String getS() {
        return s;
    }

    public int solve() {

        int j=1;
        int u=0;
        int sumOfMinimalCost = 0;
        int sameCharAmount = equalLetters();
        int[] indexesToDelete = new int[(sameCharAmount+1)];
        indexesToDelete[indexesToDelete.length-1]= -1;

        sortArrayOfCost(sameCharAmount);

        for (int i = 0; i < stringResult.length-1; i++) {
            if (stringResult[i].equals(stringResult[j]) ) {
                indexesToDelete[u++] = i;
                sumOfMinimalCost += cost[i];
            }
            j++;
        }

        deleteArrays(sameCharAmount, indexesToDelete);

        return sumOfMinimalCost;
    }

    private int equalLetters(){
        int j=1;
        int sameCharAmount =0;
        for (int i = 0; i < stringResult.length-1; i++) {
            if (stringResult[i].equals(stringResult[j]) ) {
                sameCharAmount += 1;
            }
            j++;
        }
        return sameCharAmount;
    }

    private void sortArrayOfCost(int sameCharAmount){

        for (int i = 0; i < sameCharAmount; i++) {
            int j=1;
            for (int k = 0; k < stringResult.length-1; k++) {
                if (!stringResult[k].equals(stringResult[j]) ) {
                    j++;
                } else {
                    if (cost[k] < cost[j]) {
                        j++;
                    } else {
                        int temp1 = cost[k];
                        cost[k] = cost[j];
                        cost[j] = temp1;
                        j++;
                    }
                }
            }
        }
    }

    private void deleteArrays(int sameCharAmount, int[] indexesToDelete){
        int u=0;
        int j=0;
        String[] finalResultString = new String[(stringResult.length - sameCharAmount)];
        int[] finalResultInt = new int[(stringResult.length - sameCharAmount)];
            for (int i=0; i<cost.length; i++){
            if (indexesToDelete[j] != i){
                finalResultInt[u] = cost[i];
                finalResultString[u++] = stringResult[i];
            }else {
                j++;
            }
        }
            this.s = String.join("",finalResultString);
            this.cost = finalResultInt;
    }


}
