package ua.com.fok.service;

import ua.com.fok.domain.Product;
import ua.com.fok.shared.AbstractCRUD;

import java.util.Map;

public interface ProductService extends AbstractCRUD<Product> {
    public Map<Integer, Product> readAllMap();
}
