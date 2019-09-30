package com.gl.demo.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonRootName("employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeListVO extends ResourceSupport implements Serializable
{
    private static final long serialVersionUID = 1L;
      
    private List<EmployeeVO> employees = new ArrayList<EmployeeVO>();
  
}