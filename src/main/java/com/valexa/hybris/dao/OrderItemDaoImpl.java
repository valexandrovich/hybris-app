package com.valexa.hybris.dao;

import com.valexa.hybris.config.MySqlConnector;
import com.valexa.hybris.model.Order;
import com.valexa.hybris.model.OrderItem;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class OrderItemDaoImpl implements OrderItemDao {

    @Override
    public int save(OrderItem orderItem) {
        try {
            Connection con = MySqlConnector.getConnection();
            String insertQuery = "INSERT INTO order_items (order_id, product_id, quantity) values (" +
                    orderItem.getOrderId() + ", " +
                    orderItem.getProductId() + ", " +
                    orderItem.getQuantity() +
                    ")";
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
    public OrderItem findByOrderId(int id) {
        try {
            Connection con = MySqlConnector.getConnection();
            Statement st = con.createStatement();
//            String query = "SELECT * FROM order_items"
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<OrderItem> findAll() {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
