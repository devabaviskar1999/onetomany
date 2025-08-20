package com.example.demo.service;

import com.example.demo.dto.EmployeeDtoRequest;
import com.example.demo.dto.EmployeeDtoResponse;
import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AllService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeDtoResponse addEmployee(EmployeeDtoRequest employeeDtoRequest) {
        Optional<Employee> existingEmployee = employeeRepository.findByName(employeeDtoRequest.getName());
        if (existingEmployee.isPresent()) {
            throw new RuntimeException("Employee with name " + employeeDtoRequest.getName() + " already exists");
        }
        Employee newEmployee = employeeRepository.save(modelMapper.map(employeeDtoRequest, Employee.class));
        return modelMapper.map(newEmployee, EmployeeDtoResponse.class);
    }
}
