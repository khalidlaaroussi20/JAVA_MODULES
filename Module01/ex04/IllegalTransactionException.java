package ex04;

public class IllegalTransactionException extends Exception {
    public IllegalTransactionException() {
        super("Illegal Transaction");
    }
}
