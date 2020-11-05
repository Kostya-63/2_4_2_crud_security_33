package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao dao;

    @Autowired
    public void setDao(UserDao dao) {
        this.dao = dao;
    }

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
