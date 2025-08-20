package com.example.demo.controller;

import com.example.demo.dto.EmployeeDtoRequest;

import com.example.demo.dto.EmployeeDtoResponse;
import com.example.demo.entity.Employee;
import com.example.demo.service.AllService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AllController {
    private final AllService allService;
    @PostMapping("/add-employee")
    public EmployeeDtoResponse addEmployee(@RequestBody EmployeeDtoRequest employeeDtoRequest){
   return allService.addEmployee(employeeDtoRequest);
    }

        @GetMapping("/get-all-employees")
        public Page<Employee> getAllEmployees(    @RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "5") int size,
                                                  @RequestParam(defaultValue = "name") String sortBy,
                                                  @RequestParam(defaultValue = "asc") String order){
            return allService.getAllEmployee(page, size, sortBy, order);
        }
}
