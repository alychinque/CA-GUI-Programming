/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
                + "VALUES ('"+user.getFirstName()+"', '"+user.getSurname()+"', "+user.getPhone()+", '"+user.getEmail()+"', '"+user.getPassword()+"')";

        // Get a statement from the connection
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.execute();
        connection.close();
    }

}
