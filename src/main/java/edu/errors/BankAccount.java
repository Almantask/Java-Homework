package edu.errors;

import java.math.BigDecimal;

public class BankAccount {
    private BigDecimal money;

    public BankAccount(BigDecimal money) {
        this.money = money;
    }

    public void transfer(BankAccount otherAccount, BigDecimal amount) throws InvalidTransferException {
        // if less than zero funds are being transfered.
        if(amount.compareTo(BigDecimal.ZERO) == 0 || amount.compareTo(BigDecimal.ZERO) < 0){
            throw new InvalidTransferException(amount);
        }
        else if(money.compareTo(amount) < 0){
            throw new InvalidTransferException(money, amount);
        }

        money = money.subtract(amount);
        otherAccount.money = otherAccount.money.add(amount);
    }
}
