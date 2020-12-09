package edu;

public class Demo {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBalance(10000000.0);
        BankAccount bankAccount1 = new BankAccount();
        bankAccount.setBalance(0);

        for (int i = 0; i <= 1000; i++) {
            Thread newThread = new Thread(() -> {
                bankAccount.transferMoneyTo(bankAccount1, 100);
                System.out.println(bankAccount1.getBalance());
            });
            newThread.start();
        }
    }
}
