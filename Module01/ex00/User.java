package ex00;

import javax.naming.Name;

public class User {
    private int identifier;
    private String name;
    private int balance;


    User(int identifier, String name, int balance) {
        this.identifier = identifier;
        this.name = name;
        this.setBalance(balance);
    }

    public int getIdentifier() {
        return  identifier;
    }

    public int getBalance() {
        return  balance;
    }

    public String getName() {
        return name;
    }


    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setBalance(int balance) {
        if (balance < 0)
            throw new IllegalArgumentException("balance should not be negative");
        this.balance = balance;
    }

}
