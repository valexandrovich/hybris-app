package com.valexa.hybris.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class IndexController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> words = Arrays.asList("aaa", "bbb", "cccc");
        req.setAttribute("words", words);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
}
