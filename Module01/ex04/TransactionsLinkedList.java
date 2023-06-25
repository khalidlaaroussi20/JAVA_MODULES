package ex04;

import java.util.UUID;

public class TransactionsLinkedList implements TransactionList {

    private Node<Transaction> _head;
    private int                _size;


    TransactionsLinkedList() {
        _head = null;
        _size = 0;
    }

    public void addTransaction(Transaction transaction) {
        Node<Transaction> newNode = new Node<>(transaction);
        if (_head == null) {
            _head = newNode;
        } else {
            Node<Transaction> tmp = _head;
            _head = newNode;
            newNode.next = tmp;
        }
        _size++;
    }

    public void removeTransactionById(UUID id) throws TransactionNotFoundException {
        Node<Transaction> iter = _head;
        Node<Transaction> prev = _head;
        while (iter != null) {
            if (iter.data.getIdentifier() == id) {
                prev.next = iter.next;
                _size--;
            }
            prev = iter;
            iter = iter.next;
        }
        throw new TransactionNotFoundException();
    }

    private boolean isEmpty() {
        return (_size == 0);
    }

    public Transaction[] toArray() {
        if (isEmpty())
            return (null);
        Transaction[] transactions = new Transaction[_size];
        int i = 0;
        Node<Transaction> iter = _head;
        while (iter != null) {
            transactions[i++] = iter.data;
            iter = iter.next;
        }
        return transactions;
    }
}
