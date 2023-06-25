package ex02;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("this User Not exist");
    }
}
