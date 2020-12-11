/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

/**
 *
 * @author Alysson Chinque
 */
public class UserDAO {

    private final Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(User user) throws SQLException {
        String query = "INSERT INTO customer(name_customer, surname_customer, phone_customer, email_customer, password_customer)"
                + "VALUES (?, ?, ?, ?, ?)";
        // Get a statement from the connection
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, user.getFirstName());
        stmt.setString(2, user.getSurname());
        stmt.setInt(3, user.getPhone());
        stmt.setString(4, user.getEmail());
        stmt.setString(5, user.getPassword());
        stmt.execute();
    }

    public User checkCustomer(String email, String pass) throws SQLException {
        //query to get a customer by id and password
        String sql = "SELECT * FROM customer where email_customer = ? and password_customer = ?";
        //creating a Statement assigning a connection with the select query
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, pass);
        stmt.execute();
        //catch the result
        ResultSet resultSet = stmt.getResultSet();
        User validUser = null;
        if (resultSet.next()) {
            //if there is a customer it returns the customers' details
            int id = resultSet.getInt("id_customer");
            String name = resultSet.getString("name_customer");
            String surname = resultSet.getString("surname_customer");
            validUser = new User(id, name, surname);
            return validUser;
        } else {
            return null;
        }
    }
}
