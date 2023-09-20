package fr.test.exceptions;

public class EntityNotFoundException  extends Exception {
    public EntityNotFoundException() {
        super("this Entity Not Found");
    }
}
