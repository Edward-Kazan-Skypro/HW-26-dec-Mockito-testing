package skypro.learn.dao;

import java.util.List;
public interface Dao<User> {

    User getUserByName(String name);

    List<User> getAll();
}
