package Exceptions.Exceptions2.Model.Entities;

import Exceptions.Exceptions2.Model.Exceptions.DomainException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(){}
    public Account (Integer number, String holder, Double balance, Double withdrawLimit){
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }


    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit(){
        return withdrawLimit;
    }

    public void deposit(Double amount){
        balance += amount;
    }

    public void withdraw(Double amount) throws DomainException{
        if (amount > withdrawLimit){
            throw new DomainException("The amount exceeds withdraw limit");
        }
        if (amount > balance){
            throw new DomainException("Not enough balance");
        }
        balance -= amount;
    }

    @Override
    public String toString(){
        return String.format("New balance: %.2f",balance);
    }

 }
