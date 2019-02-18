package ua.com.fok.dao.impl;

import ua.com.fok.dao.UserDao;
import ua.com.fok.domain.User;
import ua.com.fok.shared.FactoryManager;
import ua.com.fok.utils.ConnectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDaoImplementation implements UserDao {

    private EntityManager em = FactoryManager.getEntityManager();

    @Override
    public User create(User user) {
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User read(Integer id) {
        User user = null;
        try {
            user = em.find(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User update(User user) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;

    }

    @Override
    public void delete(Integer id) {
        User user;
        try {
            em.getTransaction().begin();
            user = read(id);
            em.remove(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> readAll() {
        TypedQuery<User> query = null;
        try {
            query = em.createQuery("SELECT u from User u", User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Objects.requireNonNull(query).getResultList();
    }

    @Override
    public User getUserByEmail(String email) {
        User user = null;
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<User> criteria = builder.createQuery(User.class);
            Root<User> from = criteria.from(User.class);
            criteria.select(from);
            criteria.where(builder.equal(from.get("email"), email));
            TypedQuery<User> typed = em.createQuery(criteria);
            user = typed.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;

    }
}
