package org.shekhawat.coders;

import org.shekhawat.coders.domain.*;

import java.util.ArrayList;
import java.util.List;

public class ExpenseTrackerService {
    List<User> users;

    public ExpenseTrackerService() {
        this.users = new ArrayList<>();
    }

    public ExpenseTrackerService(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void splitExpense(Expense expense) {
        User paidBy = expense.getPaidBy();
        double amount = expense.getAmount();
        int totalUser = expense.getFriends().size();
        List<Transaction> transactions = new ArrayList<>();

        if (ExpenseType.EQUAL == expense.getExpenseType()) {
            System.out.println("Equals");
            double sharesPerUser = amount / (double) totalUser;
            for (User user: expense.getFriends()) {
                if (!paidBy.getUserId().equals(user.getUserId())) {
                    Transaction transaction = new Transaction(
                            user,
                            paidBy,
                            sharesPerUser
                    );
                    transactions.add(transaction);
                }
            }
        } else if (ExpenseType.EXACT == expense.getExpenseType()) {
            if (!isValidExpense(expense)) {
                return;
            }
            for (User user: expense.getFriends()) {
                double shares = expense.getExpenseMap().getOrDefault(user, 0d);
                if (shares > 0 && !paidBy.getUserId().equals(user.getUserId())) {
                    Transaction transaction = new Transaction(
                            user,
                            paidBy,
                            shares
                    );
                    transactions.add(transaction);
                }
            }
        } else {
            if (!isValidExpensePercent(expense)) {
                return;
            }
            for (User user: expense.getFriends()) {
                double shares = amount * expense.getExpenseMap().getOrDefault(user, 0d);
                if (shares > 0 && !paidBy.getUserId().equals(user.getUserId())) {
                    Transaction transaction = new Transaction(
                            user,
                            paidBy,
                            shares
                    );
                    transactions.add(transaction);
                }
            }
        }

        for (Transaction transaction: transactions) {
            User borroweruser = transaction.getBorrower();
            User lendUser = transaction.getLender();

            borroweruser.getAccount().getLenders().put(lendUser,
                    borroweruser.getAccount().getLenders().getOrDefault(lendUser, 0d) + transaction.getAmount());
            lendUser.getAccount().getBorrowers().put(borroweruser,
                    lendUser.getAccount().getBorrowers().getOrDefault(borroweruser, 0d) + transaction.getAmount());
        }
    }

    public void getExpenses(List<User> users) {
        for (User user: users) {
            System.out.println(user.getName() + " " + user.getAccount());
        }
    }

    private boolean isValidExpensePercent(Expense expense) {
        double percent = 0;
        for (double expensePercent: expense.getExpenseMap().values()) {
            percent += expensePercent;
        }
        return percent == 100d;
    }

    private boolean isValidExpense(Expense expense) {
        double totalAmount = expense.getAmount();
        double amount = 0;
        for (double expenseAmount: expense.getExpenseMap().values()) {
            amount += expenseAmount;
        }
        return totalAmount == amount;
    }
}
