package ua.com.fok.service.impl;

import ua.com.fok.dao.BucketDao;
import ua.com.fok.dao.impl.BucketDaoImplementation;
import ua.com.fok.domain.Bucket;
import ua.com.fok.service.BucketService;
import java.util.List;

public class BucketServiceImplementation implements BucketService {
    private static BucketService bucketServiceImpl;
    private BucketDao bucketDao;

    private BucketServiceImplementation() {
        bucketDao = new BucketDaoImplementation();
    }

    public static BucketService getBucketService() {
        if (bucketServiceImpl == null) {
            bucketServiceImpl = new BucketServiceImplementation();
        }

        return bucketServiceImpl;
    }

    @Override
    public Bucket create(Bucket t) {
        return bucketDao.create(t);
    }

    @Override
    public Bucket read(Integer id) {
        return bucketDao.read(id);
    }

    @Override
    public Bucket update(Bucket t) {
        return bucketDao.update(t);
    }

    @Override
    public void delete(Integer id) {
        bucketDao.delete(id);
    }

    @Override
    public List<Bucket> readAll() {
        return bucketDao.readAll();
    }

}
