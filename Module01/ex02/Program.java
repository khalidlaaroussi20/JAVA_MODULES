package ex02;

public class Program {
    public static void main(String[] args) {
        try {
            User user = new User( "khalid", 1000);
            User user1 = new User( "ayoub", 500);

            UserList userList = new UserArrayList();

            userList.addUser(user);
            userList.addUser(user1);

            System.out.println(userList.getUserById(5));
            System.out.println(userList.getUserByIndex(1));

        } catch (Exception e)  {
            System.out.println(e.getMessage());
        }


    }
}
