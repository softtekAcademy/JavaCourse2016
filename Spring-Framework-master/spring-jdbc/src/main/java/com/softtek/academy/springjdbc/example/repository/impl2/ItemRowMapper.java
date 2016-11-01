package com.softtek.academy.springjdbc.example.repository.impl2;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.softtek.academy.springjdbc.example.domain.Item;


public class ItemRowMapper implements RowMapper<Item> {

	public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Item(rs.getInt("ID"), rs.getString("DESCRIPTION"), rs.getDouble("ITEM_VALUE"));
	}


}
