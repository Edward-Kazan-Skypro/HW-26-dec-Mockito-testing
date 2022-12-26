package skypro.learn.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import skypro.learn.model.User;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    UserService userService = Mockito.mock(UserService.class);
    User user = Mockito.mock(User.class);

    @Test
    void checkExistUserMustReturnTrue() {
        Mockito.when(userService.checkUserExist(user)).thenReturn(true);
        assertTrue(userService.checkUserExist(user));
    }

    @Test
    void checkNonExistUserMustReturnFalse() {
        Mockito.when(userService.checkUserExist(user)).thenReturn(false);
        assertFalse(userService.checkUserExist(user));
    }
}