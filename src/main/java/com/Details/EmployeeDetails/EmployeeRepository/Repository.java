package com.Details.EmployeeDetails.EmployeeRepository;

import com.Details.EmployeeDetails.EmployeeModel.Employee;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<Employee, String> {
}
