package com.Details.EmployeeDetails.EmployeeController;

import com.Details.EmployeeDetails.EmployeeModel.Employee;
import com.Details.EmployeeDetails.EmployeeRepository.Repository;
import com.Details.EmployeeDetails.EmployeeService.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class MainController {

    @Autowired
    private Service service;

    @PostMapping
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee){

        String employeeId = Service.generateEmployeeId(); // for generating unique uuid
        employee.setId(employeeId);
        service.addEmployee(employee);
        return ResponseEntity.ok(employeeId);

    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return service.getAllEmployees();
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String employeeId) {
        boolean deleted = service.deleteEmployee(employeeId);

        if (deleted) {
            return ResponseEntity.ok(employeeId + "  deleted !");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<String> updateEmployee(@PathVariable String employeeId, @RequestBody Employee updatedEmployee){
        boolean updated = service.updateEmployee(employeeId, updatedEmployee);

        if(updated){
            return ResponseEntity.ok(employeeId + "  updated successfully !");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{employeeId}/manager/{level}")
    public ResponseEntity<Employee> getNthLevelManager(@PathVariable String employeeId, @PathVariable int level){
        Employee manager = service.getNthLevelManager(employeeId, level);

        if (manager != null){
            return  ResponseEntity.ok(manager);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
