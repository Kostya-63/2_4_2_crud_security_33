package web.initializer;

import org.springframework.stereotype.Component;
import web.model.Role;
import web.model.User;
import web.repository.RoleRepository;
import web.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@Component
public class DbInit {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public DbInit(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    void postConstruct() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);

        User admin = new User("admin", "normal", 190, "admin", new HashSet<>(Arrays.asList(roleAdmin, roleUser)));
        User user = new User("user", "normal", 180, "user", new HashSet<>(Collections.singleton(roleUser)));
        userRepository.save(admin);
        userRepository.save(user);
    }
}
