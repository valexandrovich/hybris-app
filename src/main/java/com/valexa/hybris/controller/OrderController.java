package com.valexa.hybris.controller;

import com.valexa.hybris.dao.OrderDaoImpl;
import com.valexa.hybris.model.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderController extends HttpServlet {

    OrderDaoImpl orderDao = new OrderDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("id") != null){
            int id = Integer.parseInt(req.getParameter("id"));
            Order order = orderDao.findById(id);
            req.setAttribute("order", order);
            req.getRequestDispatcher("order.jsp").forward(req, resp);
        }
    }
}
