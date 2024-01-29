package Exceptions.Exceptions2.Application;

import Exceptions.Exceptions2.Model.Entities.Account;
import Exceptions.Exceptions2.Model.Exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter account data ");
            System.out.print("Number: ");
            int number = sc.nextInt();
            System.out.print("Holder: ");
            sc.nextLine();
            String holder = sc.nextLine();
            System.out.print("Initial balance: ");
            double balance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();

            Account account = new Account(number, holder, balance, withdrawLimit);

            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            account.withdraw(sc.nextDouble());
            System.out.println(account);
        }
        catch (DomainException e){
            System.out.println("Withdraw error: " + e.getMessage());
        }
        catch (Exception e){
            System.out.println("Unexpected error");
        }

        sc.close();
    }
}