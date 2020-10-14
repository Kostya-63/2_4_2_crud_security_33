package web.service;

import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();



    @Override
    public List<User> allUsers() {
        return dao.allUsers();
    }

    @Override
    public void add(User user) {
        dao.add(user);
    }

    @Override
    public void edit(User user) {
        dao.edit(user);
    }

    @Override
    public void delete(User user) {
        dao.delete(user);
    }

    @Override
    public User getById(int id) {
        return dao.getById(id);
    }
}
