package ex04;

public class Program {
    public static void main(String[] args) {
        try {

            TransactionList transactionListUser = new TransactionsLinkedList();
            TransactionList transactionListUser1 = new TransactionsLinkedList();
            User user = new User( "khalid", 1000, transactionListUser);
            User user1 = new User( "ayoub", 500, transactionListUser1);

            Transaction transaction = new Transaction(user,user1, TransferCategory.credits, 250);
            Transaction transaction1 = new Transaction(user1,user, TransferCategory.credits, 500);

            transactionListUser.addTransaction(transaction);
            transactionListUser.addTransaction(transaction1);

            Transaction[] transactions = transactionListUser.toArray();
            for (int  i = 0; i < transactions.length; i++) {
                System.out.println(transactions[i]);
            }


        } catch (Exception e)  {
            System.out.println(e.getMessage());
        }


    }
}
