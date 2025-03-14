package dao;

import java.util.List;
import models.User;

public interface UserDao {
    boolean save(User user);
    User findById(Long id);
    List<User> findAll();
    void update(User entity);
    void delete(Long id);
    User findByUsername(String username);
}
