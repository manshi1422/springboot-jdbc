package com.springboot.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserDao(){

    }
    public int createTable(){
        String query="CREATE TABLE IF NOT EXISTS USERS(NAME CHAR)";
        int update = this.jdbcTemplate.update(query);
        System.out.print("created");
        return update;
    }
    public int insertUser(String name){
        String query = "Insert into users(name) values(?)";
        int update = this.jdbcTemplate.update(query,new Object[]{name});
        return update;
    }
}
