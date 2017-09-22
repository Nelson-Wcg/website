package cc.xiaoerbi.service;

import cc.xiaoerbi.dao.UserDao;
import cc.xiaoerbi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User findByName(String name) {
        return userDao.findUserByName(name);
    }
}
