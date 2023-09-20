package fr.test.exceptions;

public class AlreadyAuthenticatedException extends Exception {

    public AlreadyAuthenticatedException(String login) {
        super("this Login Is ALready authenticated: "+ login);
    }
}
