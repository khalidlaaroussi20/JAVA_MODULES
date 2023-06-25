package ex03;

public class User {
    private final int _identifier;
    private String _name;
    private int _balance;

    private TransactionList _transactionList;


    User(String name, int balance, TransactionList transactionList) {
        this._identifier = UserIdsGenerator.getInstance().generateId();
        this._name = name;
        this.setBalance(balance);
        _transactionList = transactionList;
    }

    public int getIdentifier() {
        return  _identifier;
    }

    public int getBalance() {
        return  _balance;
    }

    public String getName() {
        return _name;
    }
    
    public void setName(String name) {
        this._name = name;
    }
    public void setBalance(int balance) {
        if (balance < 0)
            throw new IllegalArgumentException("balance should not be negative");
        this._balance = balance;
    }

    @Override
    public String toString() {
        return "id = " + _identifier  + ", name = " + _name + ", balance = " + _balance;
    }

}
