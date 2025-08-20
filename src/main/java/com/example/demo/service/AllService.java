package com.example.demo.service;

import com.example.demo.dto.EmployeeDtoRequest;
import com.example.demo.dto.EmployeeDtoResponse;
import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
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

    public Page<Employee> getAllEmployee(
        int page, int size, String sortBy, String order
    ) {
        Sort sort = order.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending(): Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Employee> employeePage = employeeRepository.findAll(pageable);
        System.out.println(employeePage);
        return employeePage;
    }
}
