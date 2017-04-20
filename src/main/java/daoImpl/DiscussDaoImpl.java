package com.zufan.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zufan.dao.DiscussDao;
import com.zufan.entity.Discuss;

@Repository
public class DiscussDaoImpl implements DiscussDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addNewDiscuss(Discuss discuss) {
		
	}

	
	public Discuss getDiscussById(Long id) {
		Discuss discuss = null;
		String sql = "select * from t_discuss where id= ?";
		RowMapper<Discuss> rowMapper = new BeanPropertyRowMapper<Discuss>(
				Discuss.class);
		discuss = jdbcTemplate.queryForObject(sql, rowMapper, id);
		return discuss;
	}

}
