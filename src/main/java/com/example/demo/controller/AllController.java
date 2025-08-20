package com.example.demo.controller;

import com.example.demo.dto.EmployeeDtoRequest;

import com.example.demo.dto.EmployeeDtoResponse;
import com.example.demo.service.AllService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AllController {
    private final AllService allService;
    @PostMapping("/add-employee")
    public EmployeeDtoResponse addEmployee(@RequestBody EmployeeDtoRequest employeeDtoRequest){
   return allService.addEmployee(employeeDtoRequest);
    }
}
