package skypro.learn;

import skypro.learn.dao.DaoImpl;
import skypro.learn.model.User;
import skypro.learn.service.UserServiceImpl;

public class Main {

    private static DaoImpl userDaoImpl = new DaoImpl();
    public static void main(String[] args) {

        //Найдем пользователя с именем Tom (этот пользователь уже создан и добавлен в список)
        System.out.println(userDaoImpl.getUserByName("Tom"));
        //Посмотрим всех пользователей
        System.out.println(new DaoImpl().getAll());

        //Проверим наличие существующего пользователя
        System.out.println(new UserServiceImpl(userDaoImpl).checkUserExist(userDaoImpl.getUserByName("Tom")));

        //Создадим нового пользователя, не добавляя его в список
        User wrongUser = new User("Bob", 66);
        //Проверим его наличие
        System.out.println(new UserServiceImpl(userDaoImpl).checkUserExist(wrongUser));
    }
}