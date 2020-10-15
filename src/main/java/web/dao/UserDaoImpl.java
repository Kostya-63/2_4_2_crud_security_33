package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserDaoImpl implements UserDao{

    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, User> users = new HashMap<>();

    static {
        User vasyan = new User();
        vasyan.setId(AUTO_ID.getAndIncrement());
        vasyan.setName("Vasiliy");
        vasyan.setCharacter("funny but dumb");
        vasyan.setIQ(120);
        users.put(vasyan.getId(), vasyan);

        User lena = new User();
        lena.setId(AUTO_ID.getAndIncrement());
        lena.setName("Elena");
        lena.setCharacter("bitch");
        lena.setIQ(180);
        users.put(lena.getId(), lena);

        User anton = new User();
        anton.setId(AUTO_ID.getAndIncrement());
        anton.setName("Anton");
        anton.setCharacter("good");
        anton.setIQ(200);
        users.put(anton.getId(), anton);

        User natasha = new User();
        natasha.setId(AUTO_ID.getAndIncrement());
        natasha.setName("Natalya");
        natasha.setCharacter("too kind for a bitch");
        natasha.setIQ(170);
        users.put(natasha.getId(), natasha);
    }

    @Autowired
    public UserDaoImpl() {
    }

    @Override
    public List<User> allUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void add(User user) {
        user.setId(AUTO_ID.getAndIncrement());
        users.put(user.getId(), user);
    }

    @Override
    public void edit(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public void delete(User user) {
        users.remove(user.getId());
    }

    @Override
    public User getById(int id) {
        return users.get(id);
    }
}
