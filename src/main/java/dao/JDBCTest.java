package com.zufan.dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.zufan.daoImpl.DiscussDaoImpl;
import com.zufan.entity.Discuss;

public class JDBCTest {

	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate;
	
	private DiscussDaoImpl discussDaoImpl;

	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		System.out.println(jdbcTemplate);
	}


	public void testAdminDao() {
		Discuss discuss = null;
		String sql = "select id,title from t_discuss where id= ?";
		RowMapper<Discuss> rowMapper = new BeanPropertyRowMapper<Discuss>(
				Discuss.class);
		discuss = jdbcTemplate.queryForObject(sql, rowMapper, 1);
		System.out.println(discuss);
//		System.out.println(discussDaoImpl.getDiscussById(1L));
	}


	public void testBatchUpdate() {
		String sql = "insert into admin (name,password) values(?,?)";

		List<Object[]> batchArgs = new ArrayList<Object[]>();
		batchArgs.add(new Object[] { "aa", "aa1" });
		batchArgs.add(new Object[] { "bb", "bb1" });
		batchArgs.add(new Object[] { "cc", "cc1" });
		batchArgs.add(new Object[] { "dd", "dd1" });
		batchArgs.add(new Object[] { "ee", "ee1" });

		jdbcTemplate.batchUpdate(sql, batchArgs);
		System.out.println("success");

	}

	public void testdelete() {
		String sql = "delete from t_discuss where id=2";

		jdbcTemplate.execute(sql);
		System.out.println("success");
	}


	public void testUpdate() {
		// String sql="update admin set password='admin' where name='admin2'";
		String sql = "update t_discuss set password=? where id=?";
		jdbcTemplate.update(sql, "admin2", 2);
		System.out.println("success");

	}

	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}


	public static void main(String[] args) {
		JDBCTest test = new JDBCTest();
		test.testAdminDao();
	}

}
