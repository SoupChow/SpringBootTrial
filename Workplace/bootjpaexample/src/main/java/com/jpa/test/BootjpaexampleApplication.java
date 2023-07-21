package com.jpa.test;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.jpa.test.entities.User;
import com.jpa.test.dao.UserRepository;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
		
		UserRepository userrepository = context.getBean(UserRepository.class);
		
		List<User> users = userrepository.getUserByNameandCity("Sohini Bhattacharya", "Chandannagar");
		users.forEach(user->System.out.println(user));

		
//		List<User> users1 = userrepository.getUsers();
//		users1.forEach(user1->System.out.println(user1));
	}

}
