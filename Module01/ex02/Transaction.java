package ex02;

import java.util.UUID;

enum  TransferCategory {
    debits,
    credits
}
public class Transaction {
    private UUID identifier;
    private  User recipient;

    private  User sender;

    private TransferCategory transferCategory;

    private int transferAmount;


    Transaction( User recipient , User sender ,
                TransferCategory transferCategory, int transferAmount) {
        this.identifier = UUID.randomUUID();
        this.recipient = recipient;
        this.sender = sender;
        this.transferCategory = transferCategory;
        setTransferAmount(transferAmount);
    }

    private  void setTransferAmount(int transferAmount) {
        if (transferCategory.equals(TransferCategory.credits) && transferAmount < 0)
            throw new IllegalArgumentException("the transfer Amount must be Positive");
        if (transferCategory.equals(TransferCategory.debits) && transferAmount > 0)
            throw new IllegalArgumentException("the transfer Amount must be Negative");
        this.transferAmount = transferAmount;
    }

    public String getIdentifier() {
        return  identifier.toString();
    }

    public User getRecipient() {
        return  recipient;
    }

    public User getSender() {
        return  sender;
    }

    public TransferCategory getTransferCategory() {
        return transferCategory;
    }

    public int getTransferAmount() {
        return transferAmount;
    }


}
