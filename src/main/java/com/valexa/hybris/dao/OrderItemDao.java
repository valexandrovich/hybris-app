package com.valexa.hybris.dao;

import com.valexa.hybris.model.Order;
import com.valexa.hybris.model.OrderItem;

import java.util.List;

public interface OrderItemDao {
    int save(OrderItem orderItem);
    OrderItem findByOrderId(int id);
    List<OrderItem> findAll();
    void deleteById(int id);
}
