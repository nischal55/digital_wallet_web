package dao.daoImpl;

import dao.BaseDao;

import java.util.Collections;
import java.util.List;
import javax.persistence.*;
import utils.JpaUtil;

public class BaseDaoImpl<T> implements BaseDao<T> {

    private Class<T> entityClass;

    public BaseDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    EntityManager em = JpaUtil.getEntityManager();
    EntityTransaction tx = em.getTransaction();

    @Override
    public boolean save(T entity) {
        boolean status = false;
        try {
            tx.begin();
            em.persist(entity);
            tx.commit();
            status = true;
        } finally {
            em.close();
        }
        return status;
    }

    @Override
    public T findById(Long id) {
        try {
            return em.find(entityClass, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<T> findAll() {
        try {
            TypedQuery<T> query = em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(T entity) {
        try {
            tx.begin();
            em.merge(entity);
            tx.commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            tx.begin();
            T entity = em.find(entityClass, id);
            if (entity != null) {
                em.remove(entity);
            }
            tx.commit();
        } finally {
            em.close();
        }
    }
}
