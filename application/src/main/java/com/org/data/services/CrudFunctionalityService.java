package com.org.data.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.data.entity.Employee;
import com.org.data.repository.EmployeeRepository;

@Service
public class CrudFunctionalityService {
	
	private static final Logger logger = LoggerFactory.getLogger(CrudFunctionalityService.class);
	
	@Autowired
    private EmployeeRepository employeeRepository;

	@Transactional
	public List<Employee> getEmployees() {
		logger.info("Get all employee details");
        List<Employee> listRepo = employeeRepository.findAll();
        return listRepo;
    }
	
	@Transactional
	public void addEmployee(Employee empForm) {
		logger.info("Insert Employee");
		//Employee emp = new Employee(empForm);
		employeeRepository.save(empForm);
	}
	
	@Transactional
	public Employee getEmployeeByNo(String empNo) {
		logger.info("getEmployeeByNo");
		return employeeRepository.findByEmpNo(empNo);
	}
	
	@Transactional
	public Employee getEmployeeById(int id) {
		logger.info("getEmployeeById");
		return employeeRepository.findById(id).get();
	}
	
	@Transactional
	public Employee updateEmployee(Employee empForm) {
		logger.info("updateEmployee");
		Employee emp = employeeRepository.findById(empForm.getId()).get();
		emp.setEmpName(empForm.getEmpName());
		emp.setEmpNo(empForm.getEmpNo());
		emp.setPosition(empForm.getPosition());
		return emp;
	}
	
	public void deleteEmpl(int id) {
		logger.info("deleteemployee");
		employeeRepository.deleteById(id);;
	}
	
}
