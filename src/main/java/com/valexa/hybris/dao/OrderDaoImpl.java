package com.valexa.hybris.dao;

import com.valexa.hybris.config.MySqlConnector;
import com.valexa.hybris.model.Order;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;

public class OrderDaoImpl implements OrderDao{

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    @Override
    public void save(Order order) {
        try {
            Connection con = MySqlConnector.getConnection();
            Statement st = con.createStatement();
            String insertQuery = "INSERT INTO orders (user_id, status, createdAt) values (" +
                    order.getUserId() + ", '" +
                    order.getStatus() + "', " +
                    simpleDateFormat.format(order.getCreatedAt()) +
                    "')";

            st.execute(insertQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order findById(int id) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
