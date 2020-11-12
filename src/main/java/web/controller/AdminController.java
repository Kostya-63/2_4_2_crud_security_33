package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import java.security.Principal;
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
    public String getHomePage() {
        return "index";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/user")
    public String getUserPage(ModelMap model, Principal principal) {
        User user = userService.getUserByName(principal.getName());
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping(value = "/admin")
    public String Allusers(ModelMap model) {
        List<User> users = userService.allUsers();
        model.addAttribute("usersList", users);
        List<Role> roles = roleService.allRoles();
        model.addAttribute("rolesList", roles);
        return "UsersAndRoles";
    }

    @GetMapping(value = "/admin/editUser/{id}")
    public String editUser(@PathVariable("id") int id, ModelMap model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        List<Role> roles = roleService.allRoles();
        model.addAttribute("rolesList", roles);
        return "editUser";
    }

    @PostMapping(value = "/admin/editUser")
    public String editUser(@RequestParam("rolesUpdateUser") Long[] roleIds, @ModelAttribute("updateUser") User user) {
        for (Long roleId : roleIds) {
            user.setRoles(roleService.getById(roleId.intValue()));
        }
        userService.edit(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/admin/addUser")
    public String addUser(User user, ModelMap model) {
        List<Role> roles = roleService.allRoles();
        model.addAttribute("rolesList", roles);
        model.addAttribute("user", user);
        return "addUser";
    }

    @PostMapping(value = "/admin/addUser")
    public String addUser(@RequestParam("rolesAddUser") Long[] roleIds, @ModelAttribute("addUser") User user) {
        for (Long roleId : roleIds) {
            user.setRoles(roleService.getById(roleId.intValue()));
        }
        userService.add(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/admin/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        User user = userService.getById(id);
        userService.delete(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/admin/editRole/{id}")
    public String editRole(@PathVariable("id") int id, ModelMap model) {
        Role role = roleService.getById(id);
        model.addAttribute("role", role);
        return "editRole";
    }

    @PostMapping(value = "/admin/editRole")
    public String editRole(@ModelAttribute("updateRole") Role role) {
        roleService.edit(role);
        return "redirect:/admin";
    }

    @GetMapping(value = "/admin/addRole")
    public String addRole(Role role, ModelMap model) {
        model.addAttribute("role", role);
        return "addRole";
    }

    @PostMapping(value = "/admin/addRole")
    public String addRole(@ModelAttribute("addRole") Role role) {
        roleService.add(role);
        return "redirect:/admin";
    }

    @GetMapping(value="/admin/deleteRole/{id}")
    public String deleteRole(@PathVariable("id") int id) {
        Role role = roleService.getById(id);
        roleService.delete(role);
        return "redirect:/admin";
    }
}
