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

/**
 *
 * @author Alysson Chinque
 */
public class ComplainDAO {
    private final Connection connection;

    public ComplainDAO(Connection connection) {
        this.connection = connection;
    }
    public void setComplain(int id, String text, String date) throws SQLException{
        String query = "INSERT INTO complain(id_customer, complainText, complainDate)"
                + "VALUES (?, ?, ?)";
        //creating a Statement assigning a connection with the select query
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);
        stmt.setString(2, text);
        stmt.setString(3, date);
        stmt.execute();
    }
    
}
