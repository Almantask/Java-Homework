package MoneyExchanger;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ATMMachineTest {

    @Test
    void exchange_When_MoneyAndExchangeSumEqual_CallsExhanger() throws Exception{
        IMoneyExchanger iMoneyExchanger = new MoneyExchanger(100, 50);
        ATMMachine atmMachine = new ATMMachine(iMoneyExchanger);

        Map<Double, Integer> changedMoney = atmMachine.Exchange(100d);

        assertThat(changedMoney).containsOnly(entry(100d,1));

    }

    @Test
    void exchange_When_MoneyAndExchangeSumNotEqual_ThrowsSomeException() {
        IMoneyExchanger iMoneyExchanger = new MoneyExchanger(100, 2);
        ATMMachine atmMachine = new ATMMachine(iMoneyExchanger);

        Throwable error = assertThrows(Exception.class, () -> atmMachine.Exchange(300d));
    }
}