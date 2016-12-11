package com.softtek.academy.jstl.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.softtek.academy.jstl.connection.DriverManagerDatabase;
import com.softtek.academy.jstl.domain.model.Status;

public class StatusRepository {
	
	public List<Status> getStatus(String statusType) {
		
        final List<Status> status = new ArrayList<Status>();
        
        try (
        		Connection connection = DriverManagerDatabase.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                		"SELECT * FROM status WHERE status_type = ?");
        	) {
        	
        	preparedStatement.setString(1, statusType);
        	
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
            	status.add(new Status(rs.getLong("status_id"), rs.getString("description"), rs.getString("status_type")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		return status; 
	}

}