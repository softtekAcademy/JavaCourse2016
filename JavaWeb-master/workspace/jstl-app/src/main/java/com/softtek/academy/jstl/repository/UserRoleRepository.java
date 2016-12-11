package com.softtek.academy.jstl.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.softtek.academy.jstl.connection.DriverManagerDatabase;
import com.softtek.academy.jstl.domain.model.UserRole;

public class UserRoleRepository {
	
	public List<UserRole> list() {
        final List<UserRole> userRoles = new ArrayList<UserRole>();
        
        try (
        		Connection connection = DriverManagerDatabase.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user_role");
        	) {
        	
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
            	userRoles.add(new UserRole(rs.getString("user_role_id"), rs.getString("description")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		return userRoles; 
	}

}