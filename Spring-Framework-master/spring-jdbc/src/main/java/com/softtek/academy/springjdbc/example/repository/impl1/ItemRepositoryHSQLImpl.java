package com.softtek.academy.springjdbc.example.repository.impl1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softtek.academy.springjdbc.example.domain.Item;
import com.softtek.academy.springjdbc.example.repository.ItemRepository;
import com.softtek.academy.springjdbc.example.repository.impl2.ItemRowMapper;

@Repository
public class ItemRepositoryHSQLImpl implements ItemRepository {
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public ItemRepositoryHSQLImpl(final DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public String getItemDescription(final Integer id) {
		return this.jdbcTemplate.queryForObject("SELECT DESCRIPTION FROM ITEM WHERE ID = ?", String.class, id);
	}
	
	public Double getItemValue(final Integer id) {
		return this.jdbcTemplate.queryForObject("SELECT ITEM_VALUE FROM ITEM WHERE ID = ?", Double.class, id);
	}
	
	public Item getItemById(final Integer id) {
		Item item = null;
		Map rowMap = this.jdbcTemplate.queryForMap("SELECT * FROM ITEM WHERE ID = ?", id);
		
		if (rowMap != null) {
			item = new Item((Integer)rowMap.get("ID"), (String)rowMap.get("DESCRIPTION"), (Double)rowMap.get("ITEM_VALUE"));
		}
		
		return item;
	}
	
	public List<Item> getAllItems() {
		List<Item> items = new ArrayList<Item>();
		List<Map<String, Object>> results = this.jdbcTemplate.queryForList("SELECT * FROM ITEM");
		
		for (Map<String, Object> rowMap : results) {
			items.add(new Item((Integer)rowMap.get("ID"), (String)rowMap.get("DESCRIPTION"), (Double)rowMap.get("ITEM_VALUE")));
		}
		
		return items;
	}
	
	public List<Item> getAllItems2() {
		return this.jdbcTemplate.query("SELECT * FROM ITEM", new ItemRowMapper());
	}
	
	public void insertItem(Item item) {
		this.jdbcTemplate.update("INSERT INTO ITEM (ID, DESCRIPTION, ITEM_VALUE) VALUES (?, ?, ?)", item.getId(), item.getDescription(), item.getValue());
	}
	
	public void updateItem(Item item) {
		this.jdbcTemplate.update("UPDATE ITEM SET DESCRIPTION=?, ITEM_VALUE=? WHERE ID=?", item.getDescription(), item.getValue(), item.getId());
	}
	
	public void removeItem(Integer itemId) {
		this.jdbcTemplate.update("DELETE FROM ITEM WHERE ID=?", itemId);
	}
	
}
