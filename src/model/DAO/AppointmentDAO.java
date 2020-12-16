/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;

/**
 *
 * @author Alysson Chinque
 */
public class AppointmentDAO {
    
    private final Connection connection;
    
    public AppointmentDAO(Connection connection){
        this.connection = connection;
    }
    
}
