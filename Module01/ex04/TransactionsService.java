package ex04;


import java.util.UUID;

public class TransactionsService {

    private UserList _userList;

    TransactionsService(UserList userList) {
        _userList = userList;
    }

    void addUser(User user) {
        this._userList.addUser(user);
    }


    public int getUserBalance(int userId) throws UserNotFoundException {
        User user = _userList.getUserById(userId);
        return (user.getBalance());
    }


    public void transferTransaction(int senderId, int recieverId ,int amountTransfer) throws IllegalTransactionException, UserNotFoundException {
        if (amountTransfer < 0)
            throw  new IllegalTransactionException();
        User sender = _userList.getUserById(senderId);
        User reciever = _userList.getUserById(recieverId);
        if (sender.getBalance() < amountTransfer)
            throw  new IllegalTransactionException();
        sender.setBalance(sender.getBalance() - amountTransfer);
        reciever.setBalance(reciever.getBalance() + amountTransfer);
        Transaction transaction = new Transaction(sender, reciever, TransferCategory.debits, -amountTransfer);
        Transaction transaction1 = new Transaction(sender, reciever, TransferCategory.credits, amountTransfer);

        sender.getTransactionList().addTransaction(transaction);
        reciever.getTransactionList().addTransaction(transaction1);
    }

    public Transaction[] getTransfersUser(int userId) throws UserNotFoundException {
        User user = _userList.getUserById(userId);
        return user.getTransactionList().toArray();
    }


    public void removeTransactionUser(int userId, UUID transactionId) throws UserNotFoundException, TransactionNotFoundException {
        User user = _userList.getUserById(userId);
        user.getTransactionList().removeTransactionById(transactionId);
    }






}
