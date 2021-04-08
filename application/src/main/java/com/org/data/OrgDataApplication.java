package com.org.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.org.data.authenticator.entity.User;
import com.org.data.authenticator.repository.UserRepository;
import com.org.data.entity.Employee;
import com.org.data.repository.EmployeeRepository;

/**
 * 
 * @author Kishore Hebbar
 *
 */

@SpringBootApplication
public class OrgDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrgDataApplication.class, args);
	}

	@Bean
	ApplicationRunner init(UserRepository userRepository, EmployeeRepository empRepo) {
		return (ApplicationArguments args) ->  dataSetup(userRepository,empRepo);
	}
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * This is to load the data to DB during server startup
	 * @param userRepository
	 * @param empRepo
	 */
	private void dataSetup(UserRepository userRepository, EmployeeRepository empRepo) {
		User admin = new User("admin@test.com", passwordEncoder.encode("adminPasswd"), "ROLE_ADMIN");
		User user1 = new User("user1@test.com", passwordEncoder.encode("testMe"), "ROLE_USER");
		userRepository.save(admin);
		userRepository.save(user1);

		Employee emp1 = new Employee("101", "Test Name 1", "Manager");
		Employee emp2 = new Employee("102", "Test Name 2", "Tester");
		Employee emp3 = new Employee("103", "Test Name 3", "Developer");
		
		empRepo.save(emp1);
		empRepo.save(emp2);
		empRepo.save(emp3);
	}

}
