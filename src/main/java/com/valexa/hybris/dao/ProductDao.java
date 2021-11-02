package com.valexa.hybris.dao;

import com.valexa.hybris.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAll();
    void deleteById(int id);
    int save(Product product);
}
