package ex03;

import java.util.UUID;

public interface TransactionList {
    void addTransaction(Transaction transaction);

    void removeTransactionById(UUID id) throws TransactionNotFoundException;

    Transaction[] toArray();
}
