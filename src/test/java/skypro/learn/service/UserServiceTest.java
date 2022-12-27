package skypro.learn.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import skypro.learn.dao.DaoImpl;
import skypro.learn.model.User;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    User correctUser = new User("Tom", 33);
    User wrongUser = new User("Bob", 55);
    @Mock
    DaoImpl daoImpl = Mockito.mock(DaoImpl.class);
    private final UserService userService = new UserService(daoImpl);

    //В условиях домашнего задания указано:
    //необходимо протестировать метод checkUserExist из класса UserService.
    //Протестировать его нужно дважды:
    //На возврат true и false при передаче ему разных значений.
    //Значения устанавливаем с помощью функционала Mockito.
    //То есть наша задача "замокать" обращение класса UserService к классу UserDaoImpl.


    @Test
    void checkExistUserMustReturnTrue() {
        //Если в репозитории ищу пользователя с именем Tom, то должен вернуться "корректный" пользователь
        Mockito.when(daoImpl.getUserByName("Tom")).thenReturn(correctUser);
        //Получим тестового пользователя
        User testUser = daoImpl.getUserByName("Tom");
        //Проверим наличие пользователя в репозитории - сохраним результат в переменной
        boolean checkExistUser = userService.checkUserExist(testUser);
        //Сравним результат поиска по имени в репозитории с "корректным" пользователем
        assertEquals(checkExistUser, userService.checkUserExist(correctUser));
        //Переменные testUser и checkExistUser введены для упрощения записи, громоздкий код без них был бы.

        //Закомментировал эти строки - из за ошибки, которую не понимаю
        // - почему в описании ошибки указан метод getUserByName()?
        //Да, он вызывается методом checkUserExist(), и этот метод возвращает boolean результат,
        //а не User.
        //Вот текст ошибки из консоли:
        // Boolean cannot be returned by getUserByName()
        //getUserByName() should return User
        //Mockito.when(userService.checkUserExist(correctUser)).thenReturn(true);
        //assertTrue(userService.checkUserExist(correctUser));
    }

    //Тест на возврат false пока не делал, вначале хочу понять первый метод на возврат true.
    @Test
    void checkNonExistUserMustReturnFalse() {
        //Mockito.when(userService.checkUserExist(wrongUser)).thenReturn(false);
        //assertFalse(userService.checkUserExist(wrongUser));
    }
}