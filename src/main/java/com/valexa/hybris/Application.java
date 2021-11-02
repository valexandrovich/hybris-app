package com.valexa.hybris;

import com.valexa.hybris.dao.OrderDaoImpl;
import com.valexa.hybris.dao.OrderItemDaoImpl;
import com.valexa.hybris.dao.ProductDaoImpl;
import com.valexa.hybris.model.Order;
import com.valexa.hybris.model.OrderItem;
import com.valexa.hybris.model.Product;

import java.util.Date;

public class Application {

    static ProductDaoImpl productDao = new ProductDaoImpl();
    static OrderDaoImpl orderDao = new OrderDaoImpl();
    static OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();

    public static void main(String[] args) {


        Product p = new Product();
        p.setName("Carrot");
        p.setCreatedAt(new Date());
        p.setPrice(444);
        p.setStatus("RUNNING LOW");
        int pId = productDao.save(p);

        Order o = new Order();
        o.setStatus("DELIVERED");
        o.setCreatedAt(new Date());
        o.setUserId(555);
        int oId = orderDao.save(o);

        OrderItem oi = new OrderItem();
        oi.setOrderId(oId);
        oi.setProductId(23);
        oi.setQuantity(56);
        orderItemDao.save(oi);


    }
}
