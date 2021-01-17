package MoneyExchanger;

import java.util.HashMap;
import java.util.Map;

public class ATMMachine {
    private final IMoneyExchanger rootMoneyExchanger;

    public ATMMachine(IMoneyExchanger rootMoneyExchanger) {
        this.rootMoneyExchanger = rootMoneyExchanger;
    }


    public Map<Double, Integer> Exchange (Double moneyToChange) throws Exception {
        Map<Double, Integer> nominalsChanged = new HashMap<>();
        rootMoneyExchanger.Exchange(moneyToChange, nominalsChanged);
        Double moneyChanged = nominalsChanged
                .entrySet()
                .stream()
                .mapToDouble(entry -> entry.getKey() * entry.getValue())
                .sum();

        if (!moneyChanged.equals(moneyToChange)){
            throw new Exception("Amount requested " + moneyToChange + " mismatch amount exchanged " + moneyChanged);
        }
        //1. Calculate exchange amount
        //2. Check if money is equal moneyChange
        return nominalsChanged;
    }


}
