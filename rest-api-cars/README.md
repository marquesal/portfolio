# Spring Boot REST API

How to setup project:
1. Create user "rest" password "rest" in prefered SQL DB or update DataSourceConfig.java 
2. Run cars_db.sql script to create tables and insert values
3. Import project folder to favorite IDE
4. Run CarsApplication.java as Java Application (it will be publish to embeded Tomcat using Docker)
5. Access REST API in browser

Examples of usage:
- list of users with cars: http://localhost:8080/v1/api/users/cars/
- owned cars by user with ID=4: http://localhost:8080/v1/api/user/cars/4
- list of all users: http://localhost:8080/v1/api/users
- list of all cars: http://localhost:8080/v1/api/cars
