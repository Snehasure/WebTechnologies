package com.bookstore.model;

import java.sql.*;
import java.util.List;

public class OrderDAO {

    public void saveOrder(String name, String address, String phone, List<CartItem> cart) {

        double total = 0;
        for (CartItem item : cart) {
            total += item.getTotal();
        }

        try (Connection con = DBConnection.getConnection()) {

            String sql = "INSERT INTO orders(name,address,phone,total_amount) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, phone);
            ps.setDouble(4, total);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            int orderId = 0;

            if (rs.next()) {
                orderId = rs.getInt(1);
            }

            String itemSql = "INSERT INTO order_items(order_id,product_name,price,quantity) VALUES(?,?,?,?)";
            PreparedStatement ps2 = con.prepareStatement(itemSql);

            for (CartItem item : cart) {
                ps2.setInt(1, orderId);
                ps2.setString(2, item.getName());
                ps2.setDouble(3, item.getPrice());
                ps2.setInt(4, item.getQuantity());
                ps2.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}