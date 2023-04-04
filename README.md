# coffee-shop

This project is a sample implementation of a coffee shop system using microservices architecture. The system is composed of three microservices: Product service, Order service, and User service.

### Technologies Used
* Java
* Spring Boot
* MongoDB
* Apache Kafka
* JUnit
* Mockito
* Microservices


### Product Service
The product service is responsible for managing the products offered by the coffee shop. It provides APIs to create, read, update, and delete products.

### Order Service
The order service is responsible for managing the orders placed by customers. It provides APIs to create, read, update, and delete orders. It also integrates with the Product service to retrieve product information.

### User Service
The user service is responsible for managing the users of the coffee shop system. It provides APIs to create, read, update, and delete users.

### Installation and Setup
* Clone the repository
* Install Java 11
* Install Apache Maven
* Install MongoDB
* Install Apache Kafka
* Configure the application.properties files in each microservice with the appropriate database and Kafka connection details
* Build and run each microservice using Maven


## API Endpoints
### Product Service
GET /products
Retrieve a list of all products

GET /products/{id}
Retrieve a single product by ID

POST /products
Create a new product

PUT /products/{id}
Update an existing product by ID

DELETE /products/{id}
Delete a product by ID

### Order Service
GET /orders
Retrieve a list of all orders

GET /orders/{id}
Retrieve a single order by ID

POST /orders
Create a new order

PUT /orders/{id}
Update an existing order by ID

DELETE /orders/{id}
Delete an order by ID

### User Service
GET /users
Retrieve a list of all users

GET /users/{id}
Retrieve a single user by ID

POST /users
Create a new user

PUT /users/{id}
Update an existing user by ID

DELETE /users/{id}
Delete a user by ID

## Contributing
* Fork the repository
* Create a new branch for your changes
* Make your changes and commit them with a descriptive commit message
* Create a pull request


## License
This project is licensed under the MIT License.
