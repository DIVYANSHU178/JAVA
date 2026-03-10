package com.bank.accounts;

import java.io.FileWriter;
import java.io.IOException;
import com.bank.exception.InsufficientBalanceException;

public class Account {

    int accountNumber;
    double balance;
    double x;

    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("In Account Number: " + accountNumber + "\nAmount Deposited : "+amount + "\nNew Balance: "+balance);
        writeTransaction("Deposited: " + amount);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient Balance!");
        }
        balance -= amount;
        writeTransaction("Withdrawn: " + amount);
    }

    public void writeTransaction(String message) {
        try {
            FileWriter fw = new FileWriter("transactions.txt", true);
            fw.write("Account: " + accountNumber + " \n" + message + "\nNew Balance: "+balance+"\n\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}