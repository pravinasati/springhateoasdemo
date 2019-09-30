package com.gl.demo.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.hateoas.ResourceSupport;

@JsonRootName("employee-report")
public class EmployeeReport extends ResourceSupport implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
}
