package com.bank.main;

import java.util.Scanner;
import com.bank.accounts.SavingsAccount;
import com.bank.exception.InsufficientBalanceException;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        SavingsAccount acc = new SavingsAccount(accNo, balance);

        System.out.print("CHOOSE OPERATION: \n1->DEPOSIT\n2->WITHDRAW\nCHOICE: ");
        int choice = sc.nextInt();
        if(choice == 1) {


            System.out.print("Enter Deposit Amount: ");
            double deposit = sc.nextDouble();
            acc.deposit(deposit);
        }else if(choice == 2) {
            try {
                System.out.print("Enter Withdrawal Amount: ");
                double withdraw = sc.nextDouble();

                acc.withdraw(withdraw);

            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage()+"\nEnter Valid Amount.");
            }
        }
        System.out.println("Transaction Completed.");

        sc.close();
    }
}