package com.valexa.hybris.dao;

import com.valexa.hybris.config.MySqlConnector;
import com.valexa.hybris.model.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    @Override
    public void deleteById(int id) {
        try {
            Connection con = MySqlConnector.getConnection();
            Statement st = con.createStatement();
            st.execute("DELETE FROM products WHERE id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void save(Product product) {
        try {
            Connection con = MySqlConnector.getConnection();
            Statement st = con.createStatement();
            String insertQuery = "INSERT INTO products (name, status, price, createdAt) values ('" +
                    product.getName() + "', '" +
                    product.getStatus() + "', " +
                    product.getPrice() + ", '" +
                    simpleDateFormat.format(product.getCreatedAt()) +
                    "')";

            st.execute(insertQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Product> findAll() {
        List<Product> result = new ArrayList<>();
        try {
            Connection con =  MySqlConnector.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM products");
            while (rs.next()){
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setCreatedAt(rs.getDate("createdAt"));
                p.setStatus(rs.getString("status"));
                p.setPrice(rs.getInt("price"));
                result.add(p);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
