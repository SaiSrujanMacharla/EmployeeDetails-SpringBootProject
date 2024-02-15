package com.Details.EmployeeDetails.EmployeeService;

import com.Details.EmployeeDetails.EmployeeModel.Employee;

import com.Details.EmployeeDetails.EmployeeRepository.Repository;
import com.fasterxml.uuid.Generators;

import lombok.Setter;
import lombok.extern.flogger.Flogger;
import org.slf4j.ILoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


import java.util.List;

@Setter
@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Repository repository;
    @Autowired
    private JavaMailSender javaMailSender;

    public static String generateEmployeeId(){
        return Generators.randomBasedGenerator().generate().toString();
    }

    public void addEmployee(Employee employee) {
        if(repository != null) {
            repository.save(employee);
            sendEmailToLevelManager(employee);
        }else{
            throw new IllegalStateException("Repository is not initialized");
        }

    }

    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }

    public boolean deleteEmployee(String employeeId){
        if(repository.existsById(employeeId)){
            repository.deleteById(employeeId);
            return true;
        }
        return false;
    }

    public boolean updateEmployee(String employeeId, Employee updatedEmployee){
        if(repository.existsById(employeeId)){
            updatedEmployee.setId(employeeId);
            repository.save(updatedEmployee);
            return true;
        }
        return false;
    }


    public Employee getNthLevelManager(String employeeId, int level){
        Employee employee = repository.findById(employeeId).orElse(null);

        if(employee == null){
            return null;
        }
        return getNthLevelManagerRecursive(employee, level);
    }

    private Employee getNthLevelManagerRecursive(Employee employee, int level){
        if(level <= 0 || employee.getReportsTo() == null){
            return employee;
        }

        return getNthLevelManagerRecursive(repository.findById(employee.getReportsTo()).orElse(null), level-1);
    }


    private void sendEmailToLevelManager(Employee employee){
        if(employee.getReportsTo() != null){
            Employee manager = repository.findById(employee.getReportsTo()).orElse(null);

            if(manager != null){
                String subject = "New Employee Assigned";
                String message = String.format("%s will now work under you, Mobile number is %s and email is %s",employee.getEmployeeName(),employee.getPhoneNumber(),employee.getEmail());

                SimpleMailMessage mailMessage = new SimpleMailMessage();
                mailMessage.setTo(manager.getEmail());
                mailMessage.setSubject(subject);
                mailMessage.setText(message);

                try{
                    javaMailSender.send(mailMessage);
                }catch(MailException e){
                    e.printStackTrace();

                }
            }
        }
    }
}










