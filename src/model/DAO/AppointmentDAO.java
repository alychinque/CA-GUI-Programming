/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Appointment;

/**
 *
 * @author Alysson Chinque
 */
public class AppointmentDAO {

    private final Connection connection;

    public AppointmentDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertAppointment(Appointment appointment) throws SQLException {
        String query = "INSERT INTO appointment (id_customer, id_barber, date, time, status) VALUES(?, ?, ?, ?, ?);";
        // Get a statement from the connection
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, appointment.getIdCustomer());
        stmt.setInt(2, appointment.getIdBarber());
        stmt.setString(3, appointment.getDate());
        stmt.setString(4, appointment.getTime());
        stmt.setString(5, appointment.getStatus());

        stmt.execute();
    }
}
