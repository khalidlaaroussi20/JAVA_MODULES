package ex00;

public class Program {
    public static void main(String[] args) {
        User user = new User(1, "khalid", 1000);
        User user1 = new User(2, "ayoub", 500);

        Transaction transaction = new Transaction(user,user1, TransferCategory.credits, 1000);
        System.out.println(user);
    }
}
