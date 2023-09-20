package fr.test.services;


import fr.test.exceptions.AlreadyAuthenticatedException;
import fr.test.exceptions.EntityNotFoundException;
import fr.test.models.User;
import org.junit.jupiter.api.Test;


class UsersServiceImplTest {

//    UsersServiceImpl usersService = null;

    @Test
    public void basicTest() {

    }

    @Test
//    @DisplayName("should Authenticate Successfully When Login And Password correct and Not Authenticated Before")
    public void itShouldAuthenticateSuccessfully() throws AlreadyAuthenticatedException, EntityNotFoundException {
        //given
        User user = new User(1 , "khalid", "khalid", false);

//        UserRepository userRepositoryMock = Mockito.mock(UserRepository.class);
//
//        Mockito.when(userRepositoryMock.findByLogin(user.getLogin())).thenReturn(user);
//        usersService = new UsersServiceImpl(userRepositoryMock);
//        //then
//        boolean result = usersService.authenticate(user.getLogin(), user.getPassword());
//
//        //when
//        assertTrue(result);
//
//        Mockito.verify(userRepositoryMock, Mockito.times(1)).findByLogin(user.getLogin());
//        User expectedUpdatedUser = new User(1 , "khalid", "khalid", true);
//        Mockito.verify(userRepositoryMock, Mockito.times(1)).update(expectedUpdatedUser);
//        Mockito.reset(calculatorMock);

    }

}