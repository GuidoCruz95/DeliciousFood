
# DeliciousFood - Online Food Delivery Service

DeliciousFood is an online food delivery service that connects users, restaurants, and delivery personnel through a mobile and web application. This system allows users to search for restaurants, place orders, and track deliveries. Restaurant owners can register their restaurants, manage food offerings, and receive orders, while delivery personnel can register their details and be notified of orders to deliver.

## Main Features

### User Registration
- Users can register by providing personal information such as name, address, and cellphone number.
- Users can also log in via Facebook.
- They can set the category of their preferred restaurant (e.g., Chinese, Fast Food, Coffee).
- Billing information and geographical location can be registered for accurate order placement.

### Restaurant Registration
- Restaurant owners can register by providing personal contact information (e.g., name, cellphone number).
- Owners can categorize their restaurant (e.g., Chinese Food, Fast Food, Café).
- They can add food offerings, including pictures, descriptions, and prices.
- Restaurants can set their billing and geographical details to ensure delivery.

### Delivery Man Registration
- Delivery personnel can register their personal information and login via Facebook.
- They can also register their vehicle details for efficient order delivery.

### Food Ordering
- Users can search for restaurants by category (e.g., Chinese, Fast Food, Coffee).
- Users can select food items, specify the quantity, and set a delivery location.
- Restaurants receive notifications when a new order is placed, including the details of the order.
- Delivery personnel receive notifications when an order is "Ready to Ship", including the origin and destination details for delivery.

### Order Tracking
- Users can track their orders in real-time, with statuses such as:
    - "Ordered"
    - "Ready to Ship"
    - "Out for Delivery"
    - "Delivered"

## Technologies Used
- **Spring Boot**: The core framework for building the service.
- **Spring Data JPA**: For database interactions.
- **Spring Security**: For authentication and authorization.
- **Gradle**: For build automation.
- **PostgreSQL**: The database used for storing user, restaurant, and order data.

## Running the Application

### Prerequisites
- JDK 17 or higher.
- PostgreSQL database.
- Gradle for building and running the project.

### Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/deliciousfood.git
   ```

2. Navigate into the project directory:
   ```bash
   cd deliciousfood
   ```

3. Set up your database configuration in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/deliciousfood
   spring.datasource.username=yourusername
   spring.datasource.password=yourpassword
   ```

4. Build the project using Gradle:
   ```bash
   gradle build
   ```

5. Run the Spring Boot application:
   ```bash
   gradle bootRun
   ```

6. The application will be accessible at:
    - API: `http://localhost:8080/api`

## API Endpoints

- **POST** `/api/users/register`: Register a new user.
- **POST** `/api/users/login`: User login (e.g., with Facebook).
- **POST** `/api/restaurants/register`: Register a new restaurant.
- **PUT** `/api/restaurants/{id}`: Update a restaurant.
- **PUT** `/api/restaurants/add-menu/{restaurantId}`: Add menu to the restaurant.
- **GET** `/api/restaurants/category/{category}`: Get Restaurants By category.
- **POST** `/api/orders`: Place a new food order.
- **GET** `/api/orders/{orderId}`: Get order by id.
- **PUT** `/api/orders/{orderId}/status`: Update Order status.
- **POST** `/api/food`: Create a new Order.
- **POST** `/api/food/restaurant/{restaurantId}`: Get Food Items by restaurant Id.
- **POST** `/api/deliverymen/register`: Register a new delivery men.
- **PUT** `/api/deliverymen/updateVehicleInformation/{id}`: Update Vehicle Information.