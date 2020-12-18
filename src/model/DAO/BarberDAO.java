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
import model.Barber;

/**
 *
 * @author Alysson Chinque
 */
public class BarberDAO {

    private final Connection connection;
    private Barber validBarber = null;
    private Barber listBarber;

    public BarberDAO(Connection connection) {
        this.connection = connection;
    }

    //THIS METHOD INSERT A BARBER IN THE DATABASE
    public void insert(Barber barber) throws SQLException {
        String query = "INSERT INTO barber(name_barber, surname_barber, phone_barber, email_barber, password_barber, barbershop, address, location)"
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

    //THIS METHOD CHECKS ACCORDING EMAIL AND PASS IF THERE IS A BARBER STORED
    public Barber checkBarber(String email, String pass) throws SQLException {
        //query to get a barber by id and password
        String sql = "SELECT * FROM barber where email_barber = ? and password_barber = ?";
        //creating a Statement assigning a connection with the select query
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, pass);
        stmt.execute();
        //catch the result
        ResultSet resultSet = stmt.getResultSet();

        if (resultSet.next()) {
            //if there is a barber it returns the customers' details
            int id = resultSet.getInt("id_barber");
            String name = resultSet.getString("name_barber");
            String surname = resultSet.getString("surname_barber");
            validBarber = new Barber(id, name, surname);
            return validBarber;
        } else {
            return null;
        }
    }

    //THIS METHOD SEARCHES IN THE DATABASE IF THERE IS A BARBER WITH A NAME OR A LOCATION
    public String[][] search(String name, int type) throws SQLException {
        //query to get a barber by name
        String sql;
        if (type == 1){
            sql = "SELECT * FROM barber where name_barber = ?";
        }else{
            sql = "SELECT * FROM barber where location = ?";
        }
        //creating a Statement assigning a connection with the select query
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.execute();
        //catch the result
        ResultSet resultSet = stmt.getResultSet();

        String[][] data;
        ArrayList<Barber> barber = new ArrayList<>();
        while (resultSet.next()) {
            //if there is a barber it returns the customers' details
            listBarber = new Barber(resultSet.getString("name_barber"), resultSet.getString("surname_barber"), resultSet.getString("barbershop"),
                    resultSet.getString("address"), resultSet.getString("location"));

            barber.add(listBarber);
        }
        if (barber.isEmpty()){
            return null;
        }
        data = new String[barber.size()][4];
        for (int i = 0; i < barber.size(); i++) {
            for (int j = 0; j < 4; j++) {
                if (j == 0) {data[i][j] = barber.get(i).getFirstName() + " " + barber.get(i).getSurname();}
                if (j == 1) {data[i][j] = barber.get(i).getBarberShop();}
                if (j == 2) {data[i][j] = barber.get(i).getAddress();}
                if (j == 3) {data[i][j] = barber.get(i).getLocation();}
            }
        }
        
        return data;
    }

    //THIS METHOD SEARCHES AN ID BY PASSING NAME AND SURMANE OF A BARBER
    public int searchId(String name, String surname) throws SQLException{
        int id = 0;
        //query to get a barber by id and password
        String sql = "SELECT id_barber FROM barber where name_barber = ? and surname_barber = ?";
        //creating a Statement assigning a connection with the select query
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, surname);
        stmt.execute();
        //catch the result
        ResultSet resultSet = stmt.getResultSet();
        
        if (resultSet.next()) {
            //if there is a barber it returns the customers' details
            id = resultSet.getInt("id_barber");
        }
        return id;
    }
}
