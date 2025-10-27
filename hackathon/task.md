# Restaurant Collection Service

## Objective

Build a RESTful API service to manage a collection of restaurants across multiple cities. The service should support adding, updating, deleting, querying restaurant data, and sorting functionality.

---

## Requirements

### 1. Restaurant Data Model

Each restaurant has the following attributes:
- **id** (integer): Unique identifier for the restaurant.
- **name** (string): Name of the restaurant.
- **city** (string): The city where the restaurant is located.
- **estimatedCost** (integer): Estimated cost for two people.
- **averageRating** (string): Average user rating (e.g., "4.5").
- **votes** (integer): Number of user votes.

#### Example:
```json
{
    "id": 1,
    "name": "The Gourmet Kitchen",
    "city": "San Francisco",
    "estimatedCost": 2000,
    "averageRating": "4.7",
    "votes": 500
}
```

---

### 2. API Endpoints

#### 1. Add a Restaurant
- **Method**: `POST`
- **URL**: `/restaurant`
- **Request Body**: JSON object containing restaurant details.
- **Response**: HTTP 201 on successful creation.

#### 2. Update a Restaurant's Rating and Votes
- **Method**: `PUT`
- **URL**: `/restaurant/{id}`
- **Request Body**: JSON object with updated `rating`. (1 .. 5)
- **Response**: HTTP 200 on success.

#### 3. Fetch All Restaurants
- **Method**: `GET`
- **URL**: `/restaurant`
- **Response**: List of all restaurants (JSON).

#### 4. Fetch Restaurants by City
- **Method**: `GET`
- **URL**: `/restaurant/query?city={city}`
- **Response**: List of restaurants in the given city.

#### 5. Fetch Restaurant by ID
- **Method**: `GET`
- **URL**: `/restaurant/query?id={id}`
- **Response**: Details of the restaurant with the given ID.

#### 6. Delete a Restaurant
- **Method**: `DELETE`
- **URL**: `/restaurant/{id}`
- **Response**: HTTP 200 on successful deletion.

#### 7. Sort Restaurants by Rating
- **Method**: `GET`
- **URL**: `/restaurant/sort`
- **Response**: List of restaurants sorted by `averageRating` in descending order.

---

## Constraints

- Use an in-memory database (e.g., H2, SQLite) for data storage.
- Input validation:
  - Non-empty strings for `name` and `city`.
  - Valid `averageRating` between "0.0" and "5.0".
  - `estimatedCost` and `votes` must be non-negative integers.
- Handle errors gracefully:
  - HTTP 400 for invalid input.
  - HTTP 404 for restaurant not found.

---

## Bonus Features

- Implement pagination in `GET` APIs.
- Add filters for `estimatedCost` range (`minCost`, `maxCost`).
- Add an endpoint to calculate the average rating of restaurants in a city.

---

## Evaluation Criteria

1. **Correctness**: Does the API function as described?
2. **Code Quality**: Is the code clean, modular, and documented?
3. **Performance**: Can the API handle a large number of restaurants efficiently?
4. **Bonus Features**: Are extra features implemented?

---

## Technology Guidelines

- **Backend**: Use any framework (e.g., Java + Spring Boot, Python + Flask/Django, Node.js + Express).
- **Database**: Use an in-memory database like H2 or SQLite.
- **Testing**: Write unit tests for all API endpoints.

---

## Deliverables

- Source code hosted in a GitHub repository.
- Postman collection (or equivalent) for testing the API.
- Optional: Deployed service (e.g., Heroku, AWS, etc.).

---

Good luck, and happy coding! 🚀
