package org.shekhawat.coders.domain;

import java.util.List;
import java.util.Map;

public class Expense {
    User paidBy;
    double amount;
    List<User> friends;
    Map<User, Double> expenseMap;
    ExpenseType expenseType;

    public Expense(User paidBy, double amount, List<User> friends, Map<User, Double> expenseMap, ExpenseType expenseType) {
        this.paidBy = paidBy;
        this.amount = amount;
        this.friends = friends;
        this.expenseMap = expenseMap;
        this.expenseType = expenseType;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public Map<User, Double> getExpenseMap() {
        return expenseMap;
    }

    public void setExpenseMap(Map<User, Double> expenseMap) {
        this.expenseMap = expenseMap;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }
}
