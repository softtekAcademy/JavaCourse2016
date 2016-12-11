package com.softtek.academy.jstl.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.softtek.academy.jstl.connection.DriverManagerDatabase;
import com.softtek.academy.jstl.domain.model.ShipTo;

public class ShipToRepository {
	
	public List<ShipTo> list() {
		
        final List<ShipTo> shipTos = new ArrayList<ShipTo>();
        
        try (
        		Connection connection = DriverManagerDatabase.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                		"SELECT ship_to_id, CONCAT(name, ' - ', address) name FROM ship_to");
        	) {
        	
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
            	shipTos.add(new ShipTo(rs.getLong("ship_to_id"), rs.getString("name")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		return shipTos; 
	}

}