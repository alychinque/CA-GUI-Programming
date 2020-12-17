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
import java.util.ArrayList;
import java.util.Locale;
import model.Appointment;
import model.ShowAppointment;

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

    public String[][] returnAppointmet(int id) throws SQLException {
        String query = "SELECT barber.name_barber, barber.barbershop, barber.address, barber.location date, time, status \n"
                + " FROM Alysson_2019305.appointment\n"
                + " INNER JOIN barber ON barber.id_barber = appointment.id_barber\n"
                + " where appointment.id_customer = ?;";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);
        stmt.execute();
        //catch the result
        ResultSet resultSet = stmt.getResultSet();

        String[][] data;
        ShowAppointment appointment;
        ArrayList<ShowAppointment> retAppointment = new ArrayList<>();
        //if there are data it shows, otherwise return true and insert
        while (resultSet.next()) {
            //it gets the appointment and barber' details from DB and store in new variables
            String nameBarber = resultSet.getString("name_barber");
            String barbershop = resultSet.getString("barbershop");
            String address = resultSet.getString("address");
            String date = resultSet.getString("date");
            String time = resultSet.getString("time");
            String status = resultSet.getString("status");

            appointment = new ShowAppointment(nameBarber, barbershop, address, date, time, status);
            retAppointment.add(appointment);
        }
        data = new String[retAppointment.size()][6];
        for (int i = 0; i < retAppointment.size(); i++) {
            for (int j = 0; j < 6; j++) {
                if (j == 0) {
                    data[i][j] = retAppointment.get(i).getNameBarber();
                }
                if (j == 1) {
                    data[i][j] = retAppointment.get(i).getBarberShop();
                }
                if (j == 2) {
                    data[i][j] = retAppointment.get(i).getAddress();
                }
                if (j == 3) {
                    data[i][j] = retAppointment.get(i).getDay();
                }
                if (j == 4) {
                    data[i][j] = retAppointment.get(i).getTime();
                }
                if (j == 5) {
                    data[i][j] = retAppointment.get(i).getStatus();
                }
            }
        }
        return data;
    }
}
