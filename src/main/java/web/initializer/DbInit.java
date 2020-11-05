package web.initializer;

import org.springframework.stereotype.Component;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import javax.annotation.PostConstruct;
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
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        Role roleSuperAdmin = new Role( "ROLE_SUPER_ADMIN");
        roleService.add(roleAdmin);
        roleService.add(roleUser);
        roleService.add(roleSuperAdmin);

        User admin = new User("admin", "normal", 190, "admin", new HashSet<>());
        admin.setRoles(roleAdmin);
        admin.setName("admin");
        userService.add(admin);
    }
}
