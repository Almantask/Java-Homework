package MoneyExchanger;

import java.util.Map;

public interface IMoneyExchanger {
    public void Exchange(double money, Map<Double, Integer> change);
}
