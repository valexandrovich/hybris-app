package com.valexa.hybris.dao;

import com.valexa.hybris.config.MySqlConnector;
import com.valexa.hybris.model.Order;
import com.valexa.hybris.model.Product;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    @Override
    public int save(Order order) {
        try {
            Connection con = MySqlConnector.getConnection();
            String insertQuery = "INSERT INTO orders (user_id, status, createdAt) values (" +
                    order.getUserId() + ", '" +
                    order.getStatus() + "', '" +
                    simpleDateFormat.format(order.getCreatedAt()) +
                    "');";
            Statement st = con.createStatement();
            st.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next() && rs != null) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;


    }

    @Override
    public Order findById(int id) {
        Order result = new Order();
        try {
            Connection con = MySqlConnector.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM orders WHERE id=" + id + ";");
//            while (rs.next()){
            rs.next();
            result.setId(rs.getInt("id"));
            result.setUserId(rs.getInt("user_id"));
            result.setStatus(rs.getString("status"));
            result.setCreatedAt(rs.getDate("createdAt"));
//            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Order> findAll() {
        List<Order> result = new ArrayList<>();
        try {
            Connection con = MySqlConnector.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM orders;");
            while (rs.next()) {

                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setUserId(rs.getInt("user_id"));
                order.setStatus(rs.getString("status"));
                order.setCreatedAt(rs.getDate("createdAt"));
                result.add(order);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void deleteById(int id) {

    }
}
