/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import model.User;

/**
 *
 * @author alych
 */
public class UserDAO {

    private final Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(User user) throws SQLException {
        String query = "INSERT INTO customer(name_customer, surname_customer, phone_customer, email_customer, password_customer)"
                + "VALUES (?, ?, ?, ?, ?)";
                //'"+user.getFirstName()+"', '"+user.getSurname()+"', "+user.getPhone()+", '"+user.getEmail()+"', '"+user.getPassword()+"'
        // Get a statement from the connection
//        PreparedStatement Statement = ;
        PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, user.getFirstName());
        stmt.setString(2, user.getSurname());
        stmt.setInt(3, user.getPhone());
        stmt.setString(4, user.getEmail());
        stmt.setString(5, user.getPassword());
        stmt.execute();
        connection.close();
    }

}
