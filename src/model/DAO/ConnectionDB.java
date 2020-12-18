/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Alysson Chinque
 */
public class ConnectionDB {

    //CREATED A CONNECTION WITH THE DATABASE
    public Connection getConnection() throws SQLException {
        String dbServer = "jdbc:mysql://apontejaj.com:3306/Alysson_2019305?useSSL=false";
        String user = "Alysson_2019305";
        String password = "2019305";

        // Get a connection to the database
        Connection conn = DriverManager.getConnection(dbServer, user, password);
        return conn;
    }
}
