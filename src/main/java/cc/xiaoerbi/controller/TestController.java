package cc.xiaoerbi.controller;

import cc.xiaoerbi.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private UserService userService;

    @Autowired
    public TestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/test")
    public String test(@RequestParam("name") String name) {

        return JSONObject.fromObject(userService.findByName(name)).toString();
    }
}
