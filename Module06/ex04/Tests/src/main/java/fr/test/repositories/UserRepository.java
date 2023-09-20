package fr.test.repositories;

import fr.test.exceptions.EntityNotFoundException;
import fr.test.models.User;

public interface UserRepository {
    User findByLogin(String login) throws EntityNotFoundException;
    void update(User user);
}
