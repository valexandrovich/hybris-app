package com.valexa.hybris.controller;

import com.valexa.hybris.dao.OrderDaoImpl;
import com.valexa.hybris.dao.OrderItemDaoImpl;
import com.valexa.hybris.model.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class IndexController extends HttpServlet {

    OrderDaoImpl orderDao = new OrderDaoImpl();
    OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderDao.findAll();
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
}
