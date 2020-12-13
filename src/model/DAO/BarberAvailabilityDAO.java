/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import model.BarberAvailability;

/**
 *
 * @author alych
 */
public class BarberAvailabilityDAO {
    private final Connection connection;

    public BarberAvailabilityDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(BarberAvailability availability) throws SQLException {
         String query = "INSERT INTO barber_availability (id_barber, date, time)"
                + "VALUES (?, ?, ?)";
        // Get a statement from the connection
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, availability.getId());
        stmt.setString(2, availability.getDateAva());
        stmt.setString(3, Arrays.toString(availability.getTime()));
        
        stmt.execute();
    }
    
    
}
