package fr.test.services;


import fr.test.exceptions.AlreadyAuthenticatedException;
import fr.test.exceptions.EntityNotFoundException;
import fr.test.repositories.UserRepository;
import org.junit.jupiter.api.DisplayName;

import fr.test.models.User;
import org.junit.jupiter.api.Test;

import  static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mockito;



class UsersServiceImplTest {

    UsersServiceImpl usersService = null;

    @Test
    @DisplayName("should Authenticate Successfully When Login And Password correct and Not Authenticated Before")
    public void itShouldAuthenticateUserSuccessfully() throws AlreadyAuthenticatedException, EntityNotFoundException {
        //given
        User user = new User(1 , "khalid", "khalid", false);

        UserRepository userRepositoryMock = Mockito.mock(UserRepository.class);
        Mockito.when(userRepositoryMock.findByLogin(user.getLogin())).thenReturn(user);


        usersService = new UsersServiceImpl(userRepositoryMock);
        //then
        boolean result = usersService.authenticate(user.getLogin(), user.getPassword());

        //when
        assertTrue(result);

        Mockito.verify(userRepositoryMock, Mockito.times(1)).findByLogin(user.getLogin());
        User expectedUpdatedUser = new User(1 , user.getLogin(), user.getPassword(), true);
        Mockito.verify(userRepositoryMock, Mockito.times(1)).update(expectedUpdatedUser);
        Mockito.reset(userRepositoryMock);

    }

    @Test
    public  void isShouldNotAuthenticateUserWhenLoginIncorrect() throws AlreadyAuthenticatedException, EntityNotFoundException {
        //given
        String incorrectLogin = "incorrectLogin";
        String password = "password";

        UserRepository userRepositoryMock = Mockito.mock(UserRepository.class);
        Mockito.when(userRepositoryMock.findByLogin(incorrectLogin)).thenThrow(new EntityNotFoundException());


        usersService = new UsersServiceImpl(userRepositoryMock);


        //then
        try {
            boolean result = usersService.authenticate(incorrectLogin, password);

        } catch (EntityNotFoundException e) {
            assertEquals("this Entity Not Found", e.getMessage());
        }

        Mockito.reset(userRepositoryMock);

    }


    @Test
    public  void isShouldNotAuthenticateUserWhenPasswordIncorrect() throws AlreadyAuthenticatedException, EntityNotFoundException {
        //given
        String login = "login";
        String incorrectPassword = "incorrectPassword";

        //given
        User user = new User(1 , login, "password", false);

        UserRepository userRepositoryMock = Mockito.mock(UserRepository.class);
        Mockito.when(userRepositoryMock.findByLogin(user.getLogin())).thenReturn(user);


        usersService = new UsersServiceImpl(userRepositoryMock);
        //then
        boolean result = usersService.authenticate(login, incorrectPassword);

        //when
        Mockito.verify(userRepositoryMock, Mockito.times(1)).findByLogin(user.getLogin());
        assertFalse(result);


        Mockito.reset(userRepositoryMock);

    }

    @Test
    public  void isShouldNotAuthenticateUserWhenUserAlreadyAuthenticated() throws AlreadyAuthenticatedException, EntityNotFoundException {
        //given
        String login = "login";
        String password = "password";

        //given
        User user = new User(1 , login, password, true);

        UserRepository userRepositoryMock = Mockito.mock(UserRepository.class);
        Mockito.when(userRepositoryMock.findByLogin(user.getLogin())).thenReturn(user);


        usersService = new UsersServiceImpl(userRepositoryMock);
        //then
        try {
            boolean result = usersService.authenticate(login, password);
        } catch (AlreadyAuthenticatedException e) {
            assertEquals("this Login Is ALready authenticated: " + login, e.getMessage());
        }

        Mockito.reset(userRepositoryMock);

    }

}