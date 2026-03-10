package com.bank.accounts;

import com.bank.exception.InsufficientBalanceException;

public class SavingsAccount extends Account {

    public SavingsAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {

        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient Balance!");
        }

        balance -= amount;
        writeTransaction("Withdrawn: " + amount);
        System.out.println("Withdrawal successful. Balance: " + balance);
    }
}