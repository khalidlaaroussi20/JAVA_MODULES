package ex03;

import java.util.UUID;

enum  TransferCategory {
    debits,
    credits
}
public class Transaction {
    private UUID _identifier;
    private User _recipient;

    private User _sender;

    private TransferCategory _transferCategory;

    private int _transferAmount;


    Transaction(User recipient , User sender ,
                TransferCategory transferCategory, int transferAmount) {
        this._identifier = UUID.randomUUID();
        this._recipient = recipient;
        this._sender = sender;
        this._transferCategory = transferCategory;
        set_transferAmount(transferAmount);
    }

    private  void set_transferAmount(int _transferAmount) {
        if (_transferCategory.equals(TransferCategory.credits) && _transferAmount < 0)
            throw new IllegalArgumentException("the transfer Amount must be Positive");
        if (_transferCategory.equals(TransferCategory.debits) && _transferAmount > 0)
            throw new IllegalArgumentException("the transfer Amount must be Negative");
        this._transferAmount = _transferAmount;
    }

    public UUID getIdentifier() {
        return  _identifier;
    }

    public User getRecipient() {
        return  _recipient;
    }

    public User getSender() {
        return  _sender;
    }

    public TransferCategory getTransferCategory() {
        return _transferCategory;
    }

    public int get_transferAmount() {
        return _transferAmount;
    }


    @Override
    public  String toString() {
        return  "id = " + _identifier.toString() + "\n" +
                "sender = " + _sender + "\n" +
                "recipienr = " +_recipient + "\n" +
                "category = " + _transferCategory + "\n" +
                "amount = " + _transferAmount + "\n";
    }



}
