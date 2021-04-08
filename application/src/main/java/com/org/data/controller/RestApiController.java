package com.org.data.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.org.data.entity.Employee;
import com.org.data.services.CrudFunctionalityService;
  
@RestController 
@RequestMapping(value = "/employees", produces = { MediaType.APPLICATION_JSON_VALUE, //
        MediaType.APPLICATION_XML_VALUE })
public class RestApiController {
  
    @Autowired
    private CrudFunctionalityService service;
  
    @GetMapping
    public List<Employee> getEmployees() {
        return service.getEmployees();
    }
  
    @GetMapping("/{empId}")
    public Employee getEmployee(@PathVariable("empId") Integer empId) {
    	return service.getEmployeeById(empId);
    } 
  
    @PostMapping("/create")
    public Employee addEmployee(@RequestBody Employee empForm) {
        service.addEmployee(empForm);
        return service.getEmployeeByNo(empForm.getEmpNo());
    }
  
    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee empForm) {  
        return service.updateEmployee(empForm);
    }
  
    @DeleteMapping("/{empId}")
    public void deleteEmployee(@PathVariable("empId") int empId) { 
        service.deleteEmpl(empId);
    }
  
}