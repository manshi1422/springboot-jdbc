package com.springboot.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class SpringbootJdbcApplication implements CommandLineRunner {
    @Autowired
	private UserDao userDao;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootJdbcApplication.class, args);
		System.out.print("hello");
	}
	@Override
	public void run(String...args) throws Exception{
		System.out.print(this.userDao.createTable());
		//create user
		this.createUser();
		System.out.println("created");


	}
	public void createUser() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter name");
		String name = bf.readLine();
		int i = this.userDao.insertUser(name);
		System.out.println(i);

	}

}
