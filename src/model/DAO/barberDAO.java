/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Barber;

/**
 *
 * @author Alysson Chinque
 */
public class barberDAO {

    private final Connection connection;
    
    public barberDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Barber barber) throws SQLException {
        String query= "INSERT INTO barber(name_barber, surname_barber, phone_barber, " 
                 + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // Get a statement from the connection
        PreparedStatement stmt = connection.prepareStatement(query);
         String name = barber.getFirstName();
        stmt.setString(1, name);
        stmt.setString(2, barber.getSurname());
        stmt.setInt(3, barber.getPhone());
        stmt.setString(4, barber.getEmail());
        stmt.setString(5, barber.getPassword());
        stmt.setString(6, barber.getBarberShop());
        stmt.setString(7, barber.getAddress());
        stmt.setString(8, barber.getLocation());
        stmt.execute();
    }
    
}
