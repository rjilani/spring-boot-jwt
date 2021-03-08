package com.learningservice.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class UserDao implements IUserDao{

    private static final Logger log = LoggerFactory.getLogger(UserDao.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String sql = "SELECT username, password, enabled FROM users where username=?";
    @Override
    public User findUserByname(String name) {
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql, new Object[]{name}, new UserRowMapper());
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        if (user == null) {
            log.info("user is null");
        }
        return user;
    }
}

class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new User(rs.getString("username"), rs.getString("password"),
                new ArrayList<>());
    }


}
