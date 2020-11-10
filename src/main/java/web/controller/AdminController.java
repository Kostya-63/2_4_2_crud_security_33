package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.repository.RoleRepository;
import web.repository.UserRepository;

import java.security.Principal;
import java.util.List;

@Controller
public class AdminController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public AdminController(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/user")
    public String getUserPage(ModelMap model, Principal principal) {
        User user = userRepository.getUserByName(principal.getName());
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping(value = "/admin")
    public String Allusers(ModelMap model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("usersList", users);
        List<Role> roles = roleRepository.findAll();
        model.addAttribute("rolesList", roles);
        return "UsersAndRoles";
    }

    @GetMapping(value = "/admin/editUser/{id}")
    public String editUser(@PathVariable("id") int id, ModelMap model) {
        User user = userRepository.getOne(id);
        model.addAttribute("user", user);
        List<Role> roles = roleRepository.findAll();
        model.addAttribute("rolesList", roles);
        return "editUser";
    }

    @PostMapping(value = "/admin/editUser")
    public String editUser(@RequestParam("rolesUpdateUser") Long[] roleIds, @ModelAttribute("updateUser") User user) {
        for (Long roleId : roleIds) {
            user.setRoles(roleRepository.getOne(roleId.intValue()));
        }
        userRepository.save(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/admin/addUser")
    public String addUser(User user, ModelMap model) {
        List<Role> roles = roleRepository.findAll();
        model.addAttribute("rolesList", roles);
        model.addAttribute("user", user);
        return "addUser";
    }

    @PostMapping(value = "/admin/addUser")
    public String addUser(@RequestParam("rolesAddUser") Long[] roleIds, @ModelAttribute("addUser") User user) {
        for (Long roleId : roleIds) {
            user.setRoles(roleRepository.getOne(roleId.intValue()));
        }
        userRepository.save(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/admin/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        User user = userRepository.getOne(id);
        userRepository.delete(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/admin/editRole/{id}")
    public String editRole(@PathVariable("id") int id, ModelMap model) {
        Role role = roleRepository.getOne(id);
        model.addAttribute("role", role);
        return "editRole";
    }

    @PostMapping(value = "/admin/editRole/{id}")
    public String ediRole(@ModelAttribute Role role) {
        roleRepository.save(role);
        return "redirect:/admin";
    }

    @GetMapping(value = "/admin/addRole")
    public String addRole(Role role, ModelMap model) {
        model.addAttribute("role", role);
        return "addRole";
    }

    @PostMapping(value = "/admin/addRole")
    public String addRole(@ModelAttribute Role role) {
        roleRepository.save(role);
        return "redirect:/admin";
    }

    @GetMapping(value="/admin/deleteRole/{id}")
    public String deleteRole(@PathVariable("id") int id) {
        Role role = roleRepository.getOne(id);
        roleRepository.delete(role);
        return "redirect:/admin";
    }
}
