
# Spring Boot Employee Management System




## DESCRIPTION

The work has been deployed on the "Railway.app" platform, ensuring scalability, reliability, and ease of access.

url : "https://roomy-picture-production.up.railway.app/employees"

KEY FEATURES:

MongoDB Integration: The Spring Boot project leverages the capabilities of MongoDB for efficient and scalable data storage. 

Railway.app Deployment: The backend of the application has been deployed on the Railway.app platform, a modern and developer-friendly hosting service.


Employee Management Endpoints:  
Postman endpoints has been provided below,

GET ALL EMPLOYEES : Retrieve a comprehensive list of all employees, providing essential details such as name, phone number and more.

```http
  GET             /employees
```
Ex: https://roomy-picture-production.up.railway.app/employees



ADD EMPLOYEE : Implement a secure endpoint to add an employee which assigns a unique uuid.

```http
  POST             /employees
```
Ex:https://roomy-picture-production.up.railway.app/employees  
JSON Format to add employee:

{
    "employeeName": "srujan",  
    "phoneNumber": "95435164847",  
    "email": "srujannn8465498@example.com",  
    "reportsTo": "reportingmanager584458544",  
    "profileImage": "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.cnn.com%2F2024%2F02%2F12%2Fbusiness%2Felon-musk-testify-sec-probe%2Findex.html&psig=AOvVaw3Ut_5T7e-TNNJEd6kL3h4Y&ust=1708032835142000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCOC_o6Xkq4QDFQAAAAAdAAAAABAP"

}

UPDATE EMPLOYEE BY ID: Enable the modification of employee details by providing an endpoint that updates information.

```http
  PUT               /employees/{employeeId}
```
Ex: https://roomy-picture-production.up.railway.app/employees/1a2881c7-21b8-48d5-a881-c721b8e8d500

JSON Format to Update Employee:

{
    "employeeName": "stephen",  
    "phoneNumber": "95435164847",  
    "email": "srujannn8465498@example.com",  
    "reportsTo": "reportingmanager584458544",  
    "profileImage": "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.cnn.com%2F2024%2F02%2F12%2Fbusiness%2Felon-musk-testify-sec-probe%2Findex.html&psig=AOvVaw3Ut_5T7e-TNNJEd6kL3h4Y&ust=1708032835142000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCOC_o6Xkq4QDFQAAAAAdAAAAABAP"

}


DELETE EMPLOYEE BY ID: Implement a secure endpoint to delete an employee based on their unique identifier. 

```http
  DELETE             /employees/{employeeId}
```
Ex: https://roomy-picture-production.up.railway.app/employees/1a2881c7-21b8-48d5-a881-c721b8e8d500




GET Nth MANAGER BY LEVEL :  allowing to fetch the nth manager based on the organizational level provided. This is particularly useful for visualizing and understanding reporting structures.

```http
  GET               /{employeeId}/manager/{level}
```
Ex: https://roomy-picture-production.up.railway.app/employees/0ed463e5-a1a4-4221-9463-e5a1a42221d6/manager/2

Note:Make sure that ReportsTo value must be one of the Employees Id in the database,and the level according to it.
this has to be taken care while adding Employees to Database or updating them.

EMAIL NOTIFICATION TO REPORTING MANAGER:

An innovative feature includes sending email notifications to the reporting manager when specific actions are performed. For instance, when an employee is Added, an email is automatically triggered and sent to the reporting manager.
The email subject contains essential details of the Employee.


This Can be observed when Adding a new employee using PUT (/Employees).

Note: Make sure that the value provided in ReportsTo section while adding Employee is a valid Employee Id (Manager Id) and EmailId of Manager is in working Position.

Email : "springbootdemo11@gmail.com"

Emails can be delivered from the above mail.


## prerequisites

1.Java Development Kit (JDK)   
2.Apache Maven  
3.Your preferred Integrated Development Environment (IDE) (e.g., IntelliJ, Eclipse)  
4.MongoDB Compass  
5.Postman
## SETUP

Process to run the Project on local Machine:

Extract the project file or clone the project form 
"https://github.com/SaiSrujanMacharla/EmployeeDetails-SpringBootProject.git"

Open this Project in your preffered IDE.

## Database

Open the application.properties file in the src/main/resources directory.

Update the database connection properties with your database credentials:

```http
 spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
```
Modify the URL, username, and password according to your database setup and Save Changes.

## Run Project
USING IDE:  
In your IDE, find the main class,  
Right-click on the main class file and select "Run" or "Debug."

USING MAVEN:  
Open a terminal in the project root directory.  
Run the following command:

```http
 mvn clean install
 mvn spring-boot:run
```

The Spring Boot application will start, and you can access it at http://localhost:8080 in your browser.

Use POSTMAN Endpoints and Checkout REST API Created.

