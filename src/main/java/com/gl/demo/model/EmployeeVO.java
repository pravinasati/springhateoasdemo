package com.gl.demo.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;

@JsonRootName("employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeVO extends ResourceSupport implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Integer employeeId;
 
    private String firstName;
 
    private String lastName;
 
    private String email;

}