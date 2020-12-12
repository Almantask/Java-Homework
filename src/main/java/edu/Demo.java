package edu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccount(10000000);
        BankAccount bankAccount1 = new BankAccount(0);
        ExecutorService executorService = Executors.newFixedThreadPool(1000);

            Thread newThread = new Thread(() -> {
                    for (int i = 0; i <= 1000; i++) {
                        bankAccount.transferMoneyTo(bankAccount1, 100);
                        System.out.println(bankAccount1.getBalance());
                    }
            });
            executorService.submit(newThread);
            executorService.awaitTermination(2 , TimeUnit.MILLISECONDS);
            executorService.shutdown();
        }
    }


