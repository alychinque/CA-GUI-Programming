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
import java.util.Arrays;
import javax.swing.JOptionPane;
import model.Barber;
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

    public Boolean checkDay(BarberAvailability availability) throws SQLException {
        String query = "SELECT * FROM barber_availability WHERE id_barber = ? AND date = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, availability.getId());
        stmt.setString(2, availability.getDateAva());
        stmt.execute();
        //catch the result
        ResultSet resultSet = stmt.getResultSet();

        //if there are data it shows, otherwise return true and insert
        if (resultSet.next()) {

            //it gets the barbers' details from DB and store in new variables
            int id = resultSet.getInt("id_barber");
            String date = resultSet.getString("date");
            String time = resultSet.getString("time");

            //if barber already save data it asks if they want to overwrite 
            if (id == availability.getId() && date.equals(availability.getDateAva())) {

                int returnValue = JOptionPane.showConfirmDialog(null, "You have already set the day " + date
                        + "\nwith times: " + time
                        + "\nDo you want overwrite?", "Day already set", JOptionPane.YES_NO_OPTION);

                // if yes it deletes the day, then return true and insert the new times
                if (returnValue == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Ok.");
                    deleteDay(id, date);
                    return true;

                    //if no it shows message, returns false and waits the new date 
                } else if (returnValue == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Change the day, Please");
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public void deleteDay(int id, String date) throws SQLException {
        String query = "DELETE FROM barber_availability WHERE id_barber = ? AND date = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);
        stmt.setString(2, date);
        stmt.execute();
    }

    public String[] searchDays(int id) throws SQLException {
        String query = "SELECT * FROM barber_availability WHERE id_barber = ? ORDER BY date ASC";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);
        stmt.execute();
        //catch the result
        ResultSet resultSet = stmt.getResultSet();
//        String[] days = null;
        String[] times;
        BarberAvailability barber;
        ArrayList<BarberAvailability> barberAvailability = new ArrayList<>();
        //if there are data it shows, otherwise return true and insert
        while (resultSet.next()) {
            //it gets the barbers' details from DB and store in new variables
            times = resultSet.getString("time").split(",");
            barber = new BarberAvailability(resultSet.getInt("id_barber"), resultSet.getString("date"), times);
            barberAvailability.add(barber);
        }

        String[] days = new String[barberAvailability.size()];
        for (int i = 0; i < barberAvailability.size(); i++) {
            days[i] = barberAvailability.get(i).getDateAva();
        }
        return days;

    }

    public String[] searchTime(int id, String day) throws SQLException {
        String query = "SELECT * FROM barber_availability WHERE id_barber = ? and date = ? ORDER BY date ASC";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);
        stmt.setString(2, day);
        stmt.execute();
        //catch the result
        ResultSet resultSet = stmt.getResultSet();
//        String[] days = null;
        String[] time = null;
        
        //if there are data it shows, otherwise return true and insert
        while (resultSet.next()) {
            //it gets the barbers' details from DB and store in new variables
            time = resultSet.getString("time").split(",");
        }
        return time;
    }
}
