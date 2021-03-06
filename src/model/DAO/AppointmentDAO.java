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
    
    //THIS METHOD INSERT DATA OF AN APPOINTMENT IN THE DATABASE
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

    //THIS METHOD RETRIEVE AN APPOINTMENT ACCORDING TO ID CUSTOMER
    public String[][] returnAppointmet(int id) throws SQLException {
        String query = "SELECT barber.name_barber, barber.barbershop, barber.address, date, time, status \n"
                + " FROM Alysson_2019305.appointment\n"
                + " INNER JOIN barber ON barber.id_barber = appointment.id_barber\n"
                + " where appointment.id_customer = ?"
                + " order by date asc;";
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
        //IF EMPTY RETURN NULL
        if (retAppointment.isEmpty()) {
            return null;
        }
        //CREATED THIS TWO DIMENSIONAL ARRAY TO STORE THE APPOINTMENTS
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

    //THIS METHOD RETRIEVE AN APPOINTMENT ACCORDING TO ID BARBER
    public String[][] barberAppointment(int id) throws SQLException {

        String query = "SELECT name_customer, appointment.date, appointment.time, appointment.status \n"
                + "FROM Alysson_2019305.appointment \n"
                + "INNER JOIN customer ON customer.id_customer = appointment.id_customer\n"
                + "where appointment.id_barber = ?\n"
                + "order by appointment.date asc;";
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
            String nameCustomer = resultSet.getString("name_customer");
            String date = resultSet.getString("date");
            String time = resultSet.getString("time");
            String status = resultSet.getString("status");

            appointment = new ShowAppointment(nameCustomer, date, time, status);
            retAppointment.add(appointment);
        }
        
        if (retAppointment.isEmpty()) {
            return null;
        }
        
        data = new String[retAppointment.size()][4];
        for (int i = 0; i < retAppointment.size(); i++) {
            for (int j = 0; j < 4; j++) {
                if (j == 0) {
                    data[i][j] = retAppointment.get(i).getNameCustomer();
                }
                if (j == 1) {
                    data[i][j] = retAppointment.get(i).getDay();
                }
                if (j == 2) {
                    data[i][j] = retAppointment.get(i).getTime();
                }
                if (j == 3) {
                    data[i][j] = retAppointment.get(i).getStatus();
                }
            }
        }
        return data;
    }

    //THIS METHOD SUPPOSE TO RETRIEVE BARBERS' APPOINTMENT ACCORDING TO ID BARBER AND TODAYS DATE
    public String[][] appointmentToday(int id, String today) throws SQLException {
        String query = "SELECT name_customer, appointment.date, appointment.time, appointment.status \n"
                + "FROM Alysson_2019305.customer \n"
                + "INNER JOIN appointment ON customer.id_customer = appointment.id_customer\n"
                + "where appointment.id_barber = ? and appointment.date = ?\n"
                + "order by time asc;";
        System.out.println("Sorry, I could't find how to fix this part");
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);
        stmt.setString(2, today);
        stmt.execute();
        //catch the result
        ResultSet resultSet = stmt.getResultSet();
        
        String[][] data;
        ShowAppointment appointment;
        ArrayList<ShowAppointment> retAppointment = new ArrayList<>();
        //if there are data it shows, otherwise return true and insert
        while (resultSet.next()) {
            //it gets the appointment and barber' details from DB and store in new variables
            String nameCustomer = resultSet.getString("name_customer");
            String date = resultSet.getString("date");
            String time = resultSet.getString("time");
            String status = resultSet.getString("status");

            appointment = new ShowAppointment(nameCustomer, date, time, status);
            retAppointment.add(appointment);
        }
        
        if (retAppointment.isEmpty()) {
            return null;
        }
        data = new String[retAppointment.size()][4];
        for (int i = 0; i < retAppointment.size(); i++) {
            for (int j = 0; j < 4; j++) {
                if (j == 0) {
                    data[i][j] = retAppointment.get(i).getNameCustomer();
                }
                if (j == 1) {
                    data[i][j] = retAppointment.get(i).getDay();
                }
                if (j == 2) {
                    data[i][j] = retAppointment.get(i).getTime();
                }
                if (j == 3) {
                    data[i][j] = retAppointment.get(i).getStatus();
                }
            }
        }
        return data;
    }

}
