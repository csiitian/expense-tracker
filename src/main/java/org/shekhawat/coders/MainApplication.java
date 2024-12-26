package org.shekhawat.coders;

import org.shekhawat.coders.domain.Expense;
import org.shekhawat.coders.domain.ExpenseType;
import org.shekhawat.coders.domain.User;
import org.shekhawat.coders.domain.UserAccount;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainApplication {

    public static void main(String[] args) {
        ExpenseTrackerService expenseTrackerService = new ExpenseTrackerService();

        User user1 = new User("u1", "u1@gmail.com", "+91 112012");
        User user2 = new User("u2", "u2@gmail.com", "+91 112012");
        User user3 = new User("u3", "u3@gmail.com", "+91 112012");
        User user4 = new User("u4", "u4@gmail.com", "+91 112012");

        expenseTrackerService.addUser(user1);
        expenseTrackerService.addUser(user2);
        expenseTrackerService.addUser(user3);
        expenseTrackerService.addUser(user4);

        // 10,0000
        Expense expense = new Expense(
                user1,
                10000d,
                Arrays.asList(user1, user2, user3, user4),
                new HashMap<>(),
                ExpenseType.EQUAL
        );

        expenseTrackerService.splitExpense(expense);

        expenseTrackerService.getExpenses(Arrays.asList(user1, user2, user3, user4));

        Map<User, Double> shares = new HashMap<>();
        shares.put(user1, 1000d);
        shares.put(user2, 4000d);
        shares.put(user3, 2000d);
        shares.put(user4, 3000d);

        Expense exactExpense = new Expense(
                user1,
                10000d,
                Arrays.asList(user1, user2, user3, user4),
                shares,
                ExpenseType.EXACT
        );

        expenseTrackerService.splitExpense(exactExpense);

        expenseTrackerService.getExpenses(Arrays.asList(user1, user2, user3, user4));
    }
}
