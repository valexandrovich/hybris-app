package com.valexa.hybris.dao;

import com.valexa.hybris.model.Order;

import java.util.List;

public interface OrderDao {
    void save(Order order);
    Order findById(int id);
    List<Order> findAll();
    void deleteById(int id);

}
