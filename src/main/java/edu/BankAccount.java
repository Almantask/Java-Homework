package edu;

public class BankAccount{

    private double balance;

    public BankAccount() {
        this.balance = 0;
    }

    public void transferMoneyTo (BankAccount bankAccount, double amount) {
        bankAccount.balance += amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

}
