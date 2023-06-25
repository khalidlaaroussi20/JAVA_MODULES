package ex03;

public class TransactionNotFoundException extends Exception {
    public TransactionNotFoundException() {
        super("this Transaction Not exist");
    }
}
