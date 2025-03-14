package dao.daoImpl;

import dao.UserDao;
import models.User;
import javax.persistence.*;
import utils.JpaUtil;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    public UserDaoImpl(){
        super(User.class);
    }

    @Override
    public User findByUsername(String username) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
            query.setParameter("username", username);
            return query.getResultStream().findFirst().orElse(null);
        } finally {
            em.close();
        }
    }

}
