package web.initializer;

import org.springframework.stereotype.Component;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@Component
public class DbInit {
    private final UserService userService;
    private final RoleService roleService;

    public DbInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    void postConstruct() {
        Role roleAdmin = new Role(1,"ROLE_ADMIN");
        Role roleUser = new Role(2,"ROLE_USER");
        roleService.add(roleAdmin);
        roleService.add(roleUser);

        User admin = new User(1,"admin", "normal", 190, "admin",
                new HashSet<>(Arrays.asList(roleAdmin, roleUser)));
        User user = new User(2,"user", "normal", 150, "user",
                new HashSet<>(Collections.singletonList(roleUser)));
        userService.add(admin);
        userService.add(user);
    }
}
