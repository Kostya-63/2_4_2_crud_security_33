package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/user")
    public String userInfo() {
        return "user";
    }

//    @GetMapping("/admin")
//    public String adminInfo() {
//        return "admin";
//    }
}
