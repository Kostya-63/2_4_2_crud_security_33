package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        return (List<User>) entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        entityManager.persist(user);
    }

    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(User user) {
        int id = user.getId();
        User delUser = entityManager.find(User.class, id);
        entityManager.remove(delUser);
    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getUserByName(String username) {
        return (User) entityManager
                .createQuery("select u from User u where u.name like :username")
                .setParameter("username", "%" + username.toLowerCase() + "%")
                .getSingleResult();
    }
}
