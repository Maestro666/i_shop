package ua.com.fok.dao.impl;

import ua.com.fok.dao.BucketDao;
import ua.com.fok.domain.Bucket;
import ua.com.fok.shared.FactoryManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

public class BucketDaoImplementation implements BucketDao {
    private EntityManager em = FactoryManager.getEntityManager();

    @Override
    public Bucket create(Bucket bucket) {
        try {
            em.getTransaction().begin();
            em.persist(bucket);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bucket;
    }

    @Override
    public Bucket read(Integer id) {
        Bucket bucket = null;
        try {
            bucket = em.find(Bucket.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bucket;
    }

    @Override
    public Bucket update(Bucket t) {
        throw new IllegalStateException("there is no update for bucket");
    }

    @Override
    public void delete(Integer id) {
        try {
            Bucket bucket = read(id);
            em.getTransaction().begin();
            em.remove(bucket);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Bucket> readAll() {
        TypedQuery query = null;
        try {
            query = em.createQuery("SELECT e FROM Bucket e", Bucket.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Objects.requireNonNull(query).getResultList();
    }
}
