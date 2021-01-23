package MoneyExchanger;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoneyExchangerTest {

    @Test
    void exchange_WhenMoneyMoreThanNominal_AddsNominalToChange_WithMaxFittingCount(){
        IMoneyExchanger exchanger = new MoneyExchanger(100, 5);
        Map<Double,Integer> change = new HashMap<>();
        exchanger.Exchange(101, change);

        assertThat(change).containsOnly(entry(100d,1));
    }


    @Test
    void exchange_WhenMoneyLessThanNominal_DoesNotDoAnything(){
        IMoneyExchanger exchanger = new MoneyExchanger(100, 1);
        Map<Double,Integer> change = new HashMap<>();
        exchanger.Exchange(20, change);

        assertThat(change).isEmpty();
        //assertThat(change).containsOnly(entry(100d,0));
    }

    @Test
    void exchange_WhenNoAvailableNominal_DoesNotDoAnything(){
        IMoneyExchanger exchanger = new MoneyExchanger(200, 0);
        Map<Double,Integer> change = new HashMap<>();
        exchanger.Exchange(500, change);

        assertThat(change).isEmpty();
        //assertThat(change).containsOnly(entry(100d,0));
    }

    @Test
    void exchange_WhenAnotherMoneyExchangerExists_CallsThatExchanger() {
        IMoneyExchanger exchanger1 = new MoneyExchanger(100, 1);
        IMoneyExchanger exchanger2 = new MoneyExchanger(200, 1, exchanger1);

        Map<Double,Integer> change = new HashMap<>();
        exchanger2.Exchange(300, change);

        assertThat(change).contains(entry(100d,1), entry(200d,1));


    }



}