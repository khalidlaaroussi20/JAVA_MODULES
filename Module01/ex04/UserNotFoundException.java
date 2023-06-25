package ex04;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("this User Not exist");
    }
}
