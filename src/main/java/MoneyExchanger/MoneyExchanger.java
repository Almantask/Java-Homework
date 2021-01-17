package MoneyExchanger;

import java.util.Map;

public class MoneyExchanger implements IMoneyExchanger {
    private double nominal;
    private int availableNominalsCount;
    private IMoneyExchanger next;

    public MoneyExchanger(double nominal, int nominalsCount) {
        this.nominal = nominal;
        this.availableNominalsCount = nominalsCount;
    }

    public MoneyExchanger(double nominal, int nominalsCount, IMoneyExchanger next) {
        this.nominal = nominal;
        this.availableNominalsCount = nominalsCount;
        this.next = next;
    }

    @Override
    public void Exchange(double money, Map<Double, Integer> change) {
        int exchangedNominalCount = calculateNominalCountToExchange(money);

        if (exchangedNominalCount > 0) {
            change.put(nominal, exchangedNominalCount);
            availableNominalsCount -= exchangedNominalCount;
            money -= exchangedNominalCount * nominal;
        }

        exchangeLeftovers(money, change);

    }

    private void exchangeLeftovers(double money, Map<Double, Integer> change) {
        boolean isMoneyLeftExchange = money > 0;
        if (isMoneyLeftExchange){
            goToNext(money, change);
        }
    }

    private int calculateNominalCountToExchange(double money) {
        int exchangeNominalCount = (int) (money / nominal);
        boolean isEnoughNominals = availableNominalsCount >= exchangeNominalCount;
        if (!isEnoughNominals) {
            exchangeNominalCount = availableNominalsCount;
        } return exchangeNominalCount;
    }

    private void goToNext(double money, Map<Double, Integer> change) {
        if (next!= null){
            next.Exchange(money, change); //daryti get next
        }
    }

}
