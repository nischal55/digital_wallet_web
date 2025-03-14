package services;

import models.User;
import dao.UserDao;
import utils.JwtUtil;

public class AuthService {
    private UserDao userDao;

    public AuthService(UserDao userDao){
        this.userDao=userDao;
    }

    public String login(String username, String password) {
        User user = userDao.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return JwtUtil.generateToken(username);
        }
        return null;
    }

    public boolean registerUser(User user) {
        boolean status = false;
        if(userDao.save(user)){
            status=true;
        }
        return status;
    }

}
