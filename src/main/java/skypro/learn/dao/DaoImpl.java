package skypro.learn.dao;

import skypro.learn.model.User;

import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements Dao<User> {

    private List<User> users = new ArrayList<>();

    public DaoImpl() {
        users.add(new User("Tom", 33));
        users.add(new User("Anna", 22));
    }

    @Override
    public User getUserByName(String name) {
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst().orElse(null);
    }

    @Override
    public List<User> getAll() {
        return users.stream().toList();
    }
}
