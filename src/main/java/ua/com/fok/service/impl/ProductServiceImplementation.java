package ua.com.fok.service.impl;

import ua.com.fok.dao.ProductDao;
import ua.com.fok.dao.impl.ProductDaoImplementation;
import ua.com.fok.domain.Product;
import ua.com.fok.service.ProductService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductServiceImplementation implements ProductService {
    private static ProductService productServiceImpl;
    private ProductDao productDao;

    private ProductServiceImplementation() {
        productDao = new ProductDaoImplementation();
    }

    public static ProductService getProductService() {
        if (productServiceImpl == null) {
            productServiceImpl = new ProductServiceImplementation();
        }

        return productServiceImpl;
    }

    @Override
    public Product create(Product t) {
        return productDao.create(t);
    }

    @Override
    public Product read(Integer id) {
        return productDao.read(id);
    }

    @Override
    public Product update(Product t) {
        return productDao.update(t);
    }

    @Override
    public void delete(Integer id) {
        productDao.delete(id);
    }

    @Override
    public List<Product> readAll() {
        return productDao.readAll();
    }

    @Override
    public Map<Integer, Product> readAllMap() {
        return  readAll().stream().collect(Collectors.toMap(Product::getId, Function.identity()));
    }
}
