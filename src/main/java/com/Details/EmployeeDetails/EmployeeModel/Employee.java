package com.Details.EmployeeDetails.EmployeeModel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    private String id;
    private String employeeName;
    private Long phoneNumber;
    private String email;
    private String reportsTo;
    private String profileImage;


}
