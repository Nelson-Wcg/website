package cc.xiaoerbi.controller;

import cc.xiaoerbi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LoginoutController {
    private UserService userService;

    @Autowired
    public LoginoutController(UserService userService) {
        this.userService = userService;
    }
}
