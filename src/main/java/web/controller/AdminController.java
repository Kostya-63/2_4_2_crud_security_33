package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @RequestMapping("/")
    public ModelAndView index () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

//    @GetMapping(value = "/{id}")
//    public User getUserPage(@PathVariable int id) {
//        return userService.getById(id);
//    }
//
    @GetMapping(value = "/admin")
    public List<User> Allusers(ModelMap model, Principal principal) {
        return userService.allUsers();
    }
//
//    @GetMapping(value = "/admin/userAdmin")
//    public String getUserAdminPage(ModelMap model, Principal principal) {
//        User user = userService.getUserByName(principal.getName());
//        model.addAttribute("user", user);
//        return "userAdmin";
//    }
//
//    @GetMapping(value = "/admin/editUser/{id}")
//    public String editUser(@PathVariable("id") int id, ModelMap model) {
//        User user = userService.getById(id);
//        model.addAttribute("user", user);
//        List<Role> roles = roleService.allRoles();
//        model.addAttribute("rolesList", roles);
//        return "editUser";
//    }
//
//    @PostMapping(value = "/admin/editUser")
//    public String editUser(@RequestParam("rolesUpdateUser") Long[] roleIds, @ModelAttribute("updateUser") User user) {
//        for (Long roleId : roleIds) {
//            user.setRoles(roleService.getById(roleId.intValue()));
//        }
//        userService.edit(user);
//        return "redirect:/admin";
//    }
//
//    @GetMapping(value = "/admin/addUser")
//    public String addUser(User user, ModelMap model, Principal principal) {
//        User userAdmin = userService.getUserByName(principal.getName());
//        model.addAttribute("userAdmin", userAdmin);
//        List<Role> roles = roleService.allRoles();
//        model.addAttribute("rolesList", roles);
//        model.addAttribute("user", user);
//        return "addUser";
//    }
//
//    @PostMapping(value = "/admin/addUser")
//    public String addUser(@RequestParam("rolesAddUser") Long[] roleIds, @ModelAttribute("addUser") User user) {
//        for (Long roleId : roleIds) {
//            user.setRoles(roleService.getById(roleId.intValue()));
//        }
//        userService.add(user);
//        return "redirect:/admin";
//    }
//
//    @GetMapping(value = "/admin/deleteUser/{id}")
//    public String deleteUser(@PathVariable("id") int id) {
//        return "redirect:/admin";
//    }
//
//    @PostMapping(value = "/admin/deleteUser")
//    public String editUser(@ModelAttribute("deleteUser") User user) {
//        User userToDel = userService.getById(user.getId());
//        userService.delete(userToDel);
//        return "redirect:/admin";
//    }
}
