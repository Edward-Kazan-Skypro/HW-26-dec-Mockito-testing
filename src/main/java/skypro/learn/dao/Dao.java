package skypro.learn.dao;

import java.util.List;
public interface Dao<T> {

    T getUserByName(String name);

    List<T> getAll();
}
