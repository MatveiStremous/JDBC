package com.example.jdbc.Server.repo;

import com.example.jdbc.Server.db.DataBaseConnection;
import com.example.jdbc.Server.entity.Shop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShopRepository {
    Connection connection = DataBaseConnection.getConnection();

    public List<Shop> getAll(){
        List<Shop> shops = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sqlResponse = "SELECT * FROM shops";
            ResultSet rs = statement.executeQuery(sqlResponse);
            while (rs.next()){
                Shop shop = new Shop();
                shop.setId(rs.getInt("id"));
                shop.setName(rs.getString("name"));
                shop.setProfit(rs.getFloat("profit"));
                shop.setAmountOfWorkers(rs.getInt("amount_of_workers"));
                shop.setSquare(rs.getFloat("square"));
                shop.setAverageSalary(rs.getFloat("average_salary"));

                shops.add(shop);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return shops;
    }

    public void addNewShop(Shop shop) {
        String sqlRequest = "INSERT INTO shops (name, profit, amount_of_workers, square, average_salary) " +
                "VALUES(?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlRequest);
            statement.setString(1, shop.getName());
            statement.setFloat(2, shop.getProfit());
            statement.setInt(3, shop.getAmountOfWorkers());
            statement.setFloat(4, shop.getSquare());
            statement.setFloat(5, shop.getAverageSalary());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteById(Integer id) {
        String sql  = "DELETE FROM shops " +
                "WHERE id = " + id;

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateShop(Shop shop) {
        String sqlRequest = "UPDATE shops SET" +
                " name = ?," +
                " profit = ?," +
                " amount_of_workers = ?," +
                " square = ?," +
                " average_salary = ?" +
                " WHERE id = ?";

        try {
            System.out.println(shop);
            PreparedStatement statement = connection.prepareStatement(sqlRequest);
            statement.setString(1, shop.getName());
            statement.setFloat(2, shop.getProfit());
            statement.setInt(3, shop.getAmountOfWorkers());
            statement.setFloat(4, shop.getSquare());
            statement.setFloat(5, shop.getAverageSalary());
            statement.setInt(6, shop.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

