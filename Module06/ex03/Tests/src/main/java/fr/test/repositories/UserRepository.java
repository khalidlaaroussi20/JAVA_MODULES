package fr.test.repositories;

import fr.test.models.User;

public interface UserRepository {
    User findByLogin(String login);
    void update(User user);
}
