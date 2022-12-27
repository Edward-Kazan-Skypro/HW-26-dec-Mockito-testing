package skypro.learn.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import skypro.learn.model.User;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    User correctUser = new User("Tom", 33);
    User wrongUser = new User("Bob", 55);
    @Mock
    UserService userService;
    @Test
    void checkExistUserMustReturnTrue() {
        Mockito.when(userService.checkUserExist(correctUser)).thenReturn(true);
        assertTrue(userService.checkUserExist(correctUser));
    }

    @Test
    void checkNonExistUserMustReturnFalse() {
        Mockito.when(userService.checkUserExist(wrongUser)).thenReturn(false);
        assertFalse(userService.checkUserExist(wrongUser));
    }
}