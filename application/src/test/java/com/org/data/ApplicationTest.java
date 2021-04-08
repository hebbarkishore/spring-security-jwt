package com.org.data;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.org.data.authenticator.filter.JwtAuthenticationFilter;
import com.org.data.authenticator.repository.UserRepository;
import com.org.data.authenticator.service.InvalidLoginAttemptHandler;
import com.org.data.authenticator.service.UserAuthDetailsService;
import com.org.data.controller.RestApiController;
import com.org.data.entity.Employee;
import com.org.data.repository.EmployeeRepository;
import com.org.data.services.CrudFunctionalityService;


@WebMvcTest(RestApiController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ApplicationTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CrudFunctionalityService service;
	
	@MockBean
	private UserAuthDetailsService userAuthDetailsService;

	@MockBean
	private InvalidLoginAttemptHandler invalidLoginAttemptHandler;

	@MockBean
	private JwtAuthenticationFilter jwtRequestFilter;

	@MockBean
	private UserRepository userRepository;

	@MockBean
	private EmployeeRepository empRepo;
	 

	@Test
	public void greetingShouldReturnMessageFromService() throws Exception {
		when(service.getEmployees()).thenReturn(Arrays.asList(new Employee("1", "Test Name", "Developer")));
		this.mockMvc.perform(get("/employees")).andExpect(jsonPath("$[0].empNo", is("1")));
	}
}
