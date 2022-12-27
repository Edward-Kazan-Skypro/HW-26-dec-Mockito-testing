package skypro.learn.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import skypro.learn.model.User;

import static org.junit.jupiter.api.Assertions.*;

class DaoImplTest {

    private final User correctUser = new User("Tom", 33);
    private final User wrongUser = new User("QQQQ", 66);

    @Test
    @DisplayName("Проверка работы метода по поиску существующего пользователя по имени")
    void getExistsUserByName() {
        assertNotNull(new DaoImpl().getUserByName(correctUser.getName()));
        assertEquals("Tom", new DaoImpl().getUserByName(correctUser.getName()).getName());
    }

    @Test
    @DisplayName("Проверка метода по поиску несуществующего пользователя по имени")
    void getNonExistsUserByName() {
        assertNull(new DaoImpl().getUserByName(wrongUser.getName()));
    }
}