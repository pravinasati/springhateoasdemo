package com.gl.demo.controller;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.demo.dao.EmployeeDB;
import com.gl.demo.model.EmployeeListVO;
import com.gl.demo.model.EmployeeReport;
import com.gl.demo.model.EmployeeVO;

@RestController
public class EmployeeController {

    public static final String EMPLOYEE_REPORT = "employee-report";

    @GetMapping("/employees")
    public EmployeeListVO getAllEmployees()
    {
    	EmployeeListVO employeesList  = new EmployeeListVO();

        EmployeeDB.getEmployeeList().forEach(employee -> {

            employee.add(getLink(employee));
            ResponseEntity<EmployeeReport> methodLinkBuilder = ControllerLinkBuilder
                    .methodOn(EmployeeController.class).getReportByEmployeeById(employee.getEmployeeId());
            Link reportLink = ControllerLinkBuilder
                    .linkTo(methodLinkBuilder)
                    .withRel(EMPLOYEE_REPORT);
            employee.add(reportLink);
            employeesList.getEmployees().add(employee);
        });
         
        Link selfLink = ControllerLinkBuilder
                .linkTo(ControllerLinkBuilder
                .methodOn(EmployeeController.class).getAllEmployees())
                .withSelfRel();
     
        employeesList.add(selfLink);
          
        return employeesList;
    }

    private Link getLink(EmployeeVO employee) {
        return ControllerLinkBuilder
                .linkTo(EmployeeController.class)
                .slash(employee.getEmployeeId())
                .withSelfRel();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeVO> getEmployeeById (@PathVariable("id") int id)
    {
    	if (id <= 3) {
            EmployeeVO employee = EmployeeDB.getEmployeeList().get(id-1);
             
            Link reportLink = ControllerLinkBuilder
                    .linkTo(ControllerLinkBuilder.methodOn(EmployeeController.class)
                    .getReportByEmployeeById(employee.getEmployeeId()))
                    .withRel("report");
             
            employee.add(getLink(employee));
            employee.add(reportLink);

            return new ResponseEntity<EmployeeVO>(employee, HttpStatus.OK);
        }
        return new ResponseEntity<EmployeeVO>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/employees/{id}/report")
    public ResponseEntity<EmployeeReport> getReportByEmployeeById (@PathVariable("id") int id)
    {
        //Do some operation and return report
        return null;
    }
}
