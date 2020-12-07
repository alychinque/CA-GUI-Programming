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
 * @author alych
 */
public class barberDAO {

    private final Connection connection;
    
    public barberDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Barber barber) throws SQLException {
        String query = "INSERT INTO barber(name_barber, surname_barber, phone_barber, "
                + "email_barber, password_barber, barbershop, address, location)"
                + "VALUES ('"+barber.getFirstName()+"', '"+barber.getSurname()+"', "+barber.getPhone()
                +", '"+barber.getEmail()+"', '"+barber.getPassword()+"', '"+barber.getBarberShop()
                +"', '"+barber.getAddress()+"', '"+barber.getLocation()+"')";

        // Get a statement from the connection
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.execute();
        connection.close();
    }
    
}
