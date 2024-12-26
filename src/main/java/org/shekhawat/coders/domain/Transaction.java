package org.shekhawat.coders.domain;

import java.util.UUID;

public class Transaction {
    String transactionId;
    User borrower;
    User lender;
    double amount;
    // lender to borrower

    public Transaction(User borrower, User lender, double amount) {
        this.transactionId = UUID.randomUUID().toString();
        this.borrower = borrower;
        this.lender = lender;
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public User getLender() {
        return lender;
    }

    public void setLender(User lender) {
        this.lender = lender;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
