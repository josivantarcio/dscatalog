# Product Catalog

This is a product catalog project developed with Java and Spring Boot. The aim of this project is to provide a REST API to manage products, allowing Create, Read, Update, and Delete (CRUD) operations.

## Technologies Used

- **Java 11**: Programming language used for project development.
- **Spring Boot 2.5**: Framework used to simplify the configuration and development of Java applications.
- **Maven**: Build automation tool and dependency management.
- **H2 Database**: In-memory database used for development and testing.
- **Postman**: Tool for testing the REST API.

## Requirements

- **JDK 11** or higher
- **Maven 3.6** or higher

## Project Setup

1. **Clone the repository**:
    ```bash
    git clone https://github.com/josivantarcio/dscatalog.git
    cd dscatalog
    ```

2. **Build the project using Maven**:
    ```bash
    mvn clean install
    ```

3. **Run the application**:
    ```bash
    mvn spring-boot:run
    ```

The application will be available at `http://localhost:8080`.

## API Documentation

Below are the available endpoints in the API. You can use Postman to test these endpoints.

### Endpoints

#### Create Product

- **URL**: `/api/products`
- **Method**: `POST`
- **Request Body**:
    ```json
    {
        "name": "Product Name",
        "description": "Product Description",
        "price": 100.0,
        "quantity": 10
    }
    ```
- **Response**:
    ```json
    {
        "id": 1,
        "name": "Product Name",
        "description": "Product Description",
        "price": 100.0,
        "quantity": 10
    }
    ```

#### List Products

- **URL**: `/api/products`
- **Method**: `GET`
- **Response**:
    ```json
    [
        {
            "id": 1,
            "name": "Product Name",
            "description": "Product Description",
            "price": 100.0,
            "quantity": 10
        },
        ...
    ]
    ```

#### Get Product by ID

- **URL**: `/api/products/{id}`
- **Method**: `GET`
- **Response**:
    ```json
    {
        "id": 1,
        "name": "Product Name",
        "description": "Product Description",
        "price": 100.0,
        "quantity": 10
    }
    ```

#### Update Product

- **URL**: `/api/products/{id}`
- **Method**: `PUT`
- **Request Body**:
    ```json
    {
        "name": "Updated Product Name",
        "description": "Updated Product Description",
        "price": 150.0,
        "quantity": 5
    }
    ```
- **Response**:
    ```json
    {
        "id": 1,
        "name": "Updated Product Name",
        "description": "Updated Product Description",
        "price": 150.0,
        "quantity": 5
    }
    ```

#### Delete Product

- **URL**: `/api/products/{id}`
- **Method**: `DELETE`
- **Response**: `204 No Content`

## H2 Database

The project uses the H2 in-memory database for development and testing purposes. You can access the H2 console to view the stored data.

- **URL**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **User**: `sa`
- **Password**: (leave blank)

## License

This project is licensed under the terms of the MIT license. See the [LICENSE](LICENSE) file for details.

## Contribution

Contributions are welcome! Feel free to open issues and pull requests.
