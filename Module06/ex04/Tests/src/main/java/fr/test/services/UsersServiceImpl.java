package fr.test.services;

import fr.test.exceptions.AlreadyAuthenticatedException;
import fr.test.exceptions.EntityNotFoundException;
import fr.test.models.User;
import fr.test.repositories.UserRepository;

public class UsersServiceImpl {
    private UserRepository userRepository = null;


    public UsersServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticate(String login, String password) throws AlreadyAuthenticatedException, EntityNotFoundException {
        User user = this.userRepository.findByLogin(login);
        if (user.isAuthenticated()) {
            throw  new AlreadyAuthenticatedException(login);
        }
        if (user.getPassword().equals(password)) {
            user.setAuthenticated(true);
            this.userRepository.update(user);
            return (true);
        }
        return (false);
    }

}
