package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import java.util.List;

@Controller
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/")
    public String users(ModelMap model) {
        List<User> users = userService.allUsers();
        model.addAttribute("usersList", users);
        List<Role> roles = roleService.allRoles();
        model.addAttribute("rolesList", roles);
        return "UsersAndRoles";
    }

    @GetMapping(value = "/editUser/{id}")
    public String editUser(@PathVariable("id") int id, ModelMap model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping(value = "/editUser/{id}")
    public String editUser(@ModelAttribute User user) {
        userService.edit(user);
        return "redirect:/";
    }

    @GetMapping(value = "/addUser")
    public String addUser(User user, ModelMap model) {
        model.addAttribute("user", user);
        return "addUser";
    }

    @PostMapping(value = "/addUser")
    public String addUser(@ModelAttribute User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping(value = "/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        User user = userService.getById(id);
        userService.delete(user);
        return "redirect:/";
    }

    @GetMapping(value = "/editRole/{id}")
    public String editRole(@PathVariable("id") int id, ModelMap model) {
        Role role = roleService.getById(id);
        model.addAttribute("role", role);
        return "editRole";
    }

    @PostMapping(value = "/editRole/{id}")
    public String ediRole(@ModelAttribute Role role) {
        roleService.edit(role);
        return "redirect:/";
    }

    @GetMapping(value = "/addRole")
    public String addRole(Role role, ModelMap model) {
        model.addAttribute("role", role);
        return "addRole";
    }

    @PostMapping(value = "/addRole")
    public String addRole(@ModelAttribute Role role) {
        roleService.add(role);
        return "redirect:/";
    }

    @GetMapping(value="/deleteRole/{id}")
    public String deleteRole(@PathVariable("id") int id) {
        Role role = roleService.getById(id);
        roleService.delete(role);
        return "redirect:/";
    }
}
