package com.valexa.hybris.controller;

import com.valexa.hybris.dao.ProductDaoImpl;
import com.valexa.hybris.model.Product;
import com.valexa.hybris.model.ProductStatus;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsController extends HttpServlet {

    ProductDaoImpl productDao;

    @Override
    public void init() throws ServletException {
        productDao = new ProductDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("del") != null){
            productDao.deleteById(Integer.parseInt(req.getParameter("del")));
        }
        List<Product> products = productDao.findAll();
        List<String> productStatuses = Arrays.asList(ProductStatus.values()).stream().map(productStatus -> productStatus.toString()).collect(Collectors.toList());
        req.setAttribute("products", products);
        req.setAttribute("productsStatuses", productStatuses);
        req.getRequestDispatcher("products.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = new Product();
        product.setPrice(Integer.parseInt(req.getParameter("price")));
        product.setName(req.getParameter("name"));
        product.setStatus(req.getParameter("status"));
        product.setCreatedAt(new Date());

        productDao.save(product);

        resp.sendRedirect("products");

    }
}
