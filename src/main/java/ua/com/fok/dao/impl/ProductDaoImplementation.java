package ua.com.fok.dao.impl;

import ua.com.fok.dao.ProductDao;
import ua.com.fok.domain.Product;
import ua.com.fok.shared.FactoryManager;
import ua.com.fok.utils.ConnectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImplementation implements ProductDao {

    private EntityManager em = FactoryManager.getEntityManager();

    @Override
    public Product create(Product product) {
        try {
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public Product read(Integer id) {
        Product product = null;
        try {
            product = em.find(Product.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public Product update(Product product) {

        try {

        } catch (Exception e) {
        }

        return product;
    }

    @Override
    public void delete(Integer id) {
        Product product = null;
        try {
            product = read(id);
            em.getTransaction().begin();
            em.remove(product);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> readAll() {
        TypedQuery query = null;
        try {
            query = em.createQuery("SELECT p FROM Product p", Product.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return query.getResultList();
    }


}
