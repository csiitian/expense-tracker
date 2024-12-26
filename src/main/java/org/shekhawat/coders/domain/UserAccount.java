package org.shekhawat.coders.domain;

import java.util.HashMap;
import java.util.Map;

public class UserAccount {
    Map<User, Double> borrowers;
    Map<User, Double> lenders;

    UserAccount() {
        this.borrowers = new HashMap<>();
        this.lenders = new HashMap<>();
    }

    public Map<User, Double> getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(Map<User, Double> borrowers) {
        this.borrowers = borrowers;
    }

    public Map<User, Double> getLenders() {
        return lenders;
    }

    public void setLenders(Map<User, Double> lenders) {
        this.lenders = lenders;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "borrowers=" + borrowers +
                ", lenders=" + lenders +
                '}';
    }
}
