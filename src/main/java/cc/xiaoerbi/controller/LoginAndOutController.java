package cc.xiaoerbi.controller;

import cc.xiaoerbi.config.WebAppConfigurer;
import cc.xiaoerbi.model.User;
import cc.xiaoerbi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginAndOutController {
    private UserService userService;

    @Autowired
    public LoginAndOutController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(@SessionAttribute(WebAppConfigurer.SESSION_KEY) String account, Model model) {
        model.addAttribute("username", account);
        return "hello";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/loginPost")
    public String loginPost(String username, String password, HttpSession session, ModelMap map) {
        User user = userService.findByName(username);
        if (user == null || !password.equals(user.getPassword())) {
            map.put("success", false);
            map.put("message", "请确认用户名及密码");
            return "login";
        }
        // 设置session
        session.setAttribute(WebAppConfigurer.SESSION_KEY, username);
        map.put("success", true);
        map.put("message", "登录成功");
        map.addAttribute("username", user.getUsername());
        return "hello";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(WebAppConfigurer.SESSION_KEY);
        return "redirect:/login";
    }
}
