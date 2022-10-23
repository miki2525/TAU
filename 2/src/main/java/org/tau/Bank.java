package org.tau;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Bank {
    private String accno;
    private String name;
    private AccType acc_type;
    private long balance;

    public Bank(String accno, String name, AccType acc_type, long balance) {
        this.accno = accno;
        this.name = name;
        this.acc_type = acc_type;
        this.balance = balance;
    }

    public Bank() {

    }

    //method to display account details
    public String showAccount() {
        return
                "Name of account holder: " + name +
                        ", Account no.: " + accno +
                        ", Account type: " + acc_type +
                        ", Balance: " + balance;
    }

    //method to deposit money
    public long deposit(long amount) {
        if (amount > 0) {
            balance = balance + amount;
        } else {
            throw new IllegalArgumentException("amount can't be 0 or less. Transaction Failed");
        }
        return balance;
    }

    //method to withdraw money
    public long withdrawal(long amount) {
        if (balance < amount && getAcc_type() == AccType.DEBIT) {
            throw new IllegalStateException("balance is less than amount. Transaction failed");
        } else if (amount <= 0) {
            throw new IllegalStateException("amount is too small. Transaction failed");
        } else {
            balance = balance - amount;
        }
        return balance;
    }

    //method to search an account number
    public boolean search(String ac_no) {
        if (accno.equals(ac_no)) {
            System.out.println(showAccount());
            return (true);
        }
        return (false);
    }

    public String getAccno() {
        return accno;
    }

    public String getName() {
        return name;
    }

    public AccType getAcc_type() {
        return acc_type;
    }

    public long getBalance() {
        return balance;
    }
}