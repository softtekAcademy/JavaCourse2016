package com.softtek.academy.jstl.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.softtek.academy.jstl.connection.DriverManagerDatabase;
import com.softtek.academy.jstl.domain.model.User;
import com.softtek.academy.jstl.domain.model.UserRole;

public class UserRepository {
	
	public List<User> list() {
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT u.*, ur.description user_role");
		sql.append("  FROM user u");
		sql.append("  JOIN user_role ur ON ur.user_role_id = u.user_role_id");
		
        final List<User> users = new ArrayList<User>();
        
        try (
        		Connection connection = DriverManagerDatabase.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        	) {
        	
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
            	users.add(this.buildUser(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		return users; 
	}
	
	public User findOne(final String username) {
		User user = null;
		
		try (
        		Connection connection = DriverManagerDatabase.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE username = ?");
        	) {
        	
			preparedStatement.setString(1, username);
			
            ResultSet rs = preparedStatement.executeQuery();
            
            rs.next();
            user = this.buildUser(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		return user;
	}
	
	private User buildUser(final ResultSet rs) throws SQLException {
		User user = new User();
		
		final int columnCount = rs.getMetaData().getColumnCount();
		
    	user.setUsername(rs.getString("username"));
    	user.setPassword(rs.getString("password"));
    	user.setName(rs.getString("name"));
    	user.setUserRole(new UserRole(rs.getString("user_role_id"), columnCount>5 ? rs.getString("user_role"): ""));
    	user.setActive(rs.getString("active"));
    	
    	return user;
	}
	
	
	public void update(final User user) {
		try (
        		Connection connection = DriverManagerDatabase.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                		"UPDATE user SET password = ?, name = ?, user_role_id = ?, active = ? WHERE username = ?");
        	) {
        	
			preparedStatement.setString(1, user.getPassword());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getUserRole().getId());
			preparedStatement.setString(4, user.getActive());
			preparedStatement.setString(5, user.getUsername());
			
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}