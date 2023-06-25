package ex02;

public class User {
    private final int identifier;
    private String name;
    private int balance;


    User(String name, int balance) {
        this.identifier = UserIdsGenerator.getInstance().generateId();
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
    
    public void setName(String name) {
        this.name = name;
    }
    public void setBalance(int balance) {
        if (balance < 0)
            throw new IllegalArgumentException("balance should not be negative");
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "id = " + identifier  + ", name = " + name + ", balance = " + balance;
    }

}
