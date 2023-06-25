package ex04;

public class TransactionNotFoundException extends Exception {
    public TransactionNotFoundException() {
        super("this Transaction Not exist");
    }
}
