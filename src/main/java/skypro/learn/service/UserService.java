package skypro.learn.service;

import skypro.learn.dao.DaoImpl;
import skypro.learn.model.User;

public class UserService {

    private final DaoImpl daoImpl;

    public UserService(DaoImpl daoImpl) {
        this.daoImpl = daoImpl;
    }

    public boolean checkUserExist(User user) {
        if (daoImpl.getUserByName(user.getName()) != null) {
            return true;
        }
        return false;
    }

}
