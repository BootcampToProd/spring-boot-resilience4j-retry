## Resilience4j Retry: Building Fault-Tolerant Spring Boot Applications
For complete understanding of Resilience4j Retry module and how we can use it inside the Spring Boot application you can checkout our blog.
<br/><br/>**Blog Link:** [Resilience4j Retry: Building Fault-Tolerant Spring Boot Applications](https://bootcamptoprod.com/spring-boot-resilience4j-retry/)
<br/>
## spring-boot-resilience4j-retry
A simple app highlighting how we can implement retry mechanism using Resilience4j in Spring Boot

## App Overview
This is a simple app wherein we are fetching the movie details based on the movie id. The movie details are fetched from external service that is called using the Spring Rest Template. For simplicity, we have created a mock controller which acts as a external service for returning the movie details.

## Retry Scenarios
We have created a single controller endpoint which accepts movie id as path parameter and query parameter retryType which accepts predefined set of values to mimic the different retry examples.

### Acceptable Values

#### For Path Parameter - Movie Id
a. **1** or **2** - Mock controller returns valid movie information<br/>
b. **3** - Mock controller returns HTTP status code 404<br/>
c. **4** or **any other numeric value** - Mock controller returns null which leads to MovieNotFound Exception

#### For Query Parameter - retryType
Different retry instances are defined inside the application.yml. To mimic different retry scenarios use:<br/>
a. **simple-retry:** simpleRetry retry instance will be triggered<br/>
b. **retry-on-exception:** retryOnException retry instance will be triggered.<br/>
c. **retry-on-exception-predicate:** retryBasedOnExceptionPredicate retry instance will be triggered.<br/>
d. **retry-on-conditional-predicate:** retryBasedOnConditionalPredicate retry instance will be triggered.<br/>
e. **retry-using-exponential-backoff:** retryUsingExponentialBackoff retry instance will be triggered.<br/>
f. **retry-using-randomized-wait:** retryUsingRandomizedWait retry instance will be triggered.<br/>
g. **retry-with-fallback:** simpleRetry retry instance will be triggered and fallback method logic will be executed in this case.<br/>
h. **retry-with-custom-config:** customRetryConfig retry instance defined in RetryConfiguration class will be triggered.<br/>
i. **retry-with-event-details:** retryWithEventDetails retry instance will be triggered.<br/>

## cURL Commands
Check the application logs in order to get the better understanding of different retry scenarios.

### 1. Simple Retry
```
curl 'http://localhost:8080/movies/3?retryType=simple-retry'
```

### 2. Retry on Configured Exceptions
```
curl 'http://localhost:8080/movies/3?retryType=retry-on-exception'
```

### 3. Retry on Exception Predicate
```
curl 'http://localhost:8080/movies/4?retryType=retry-on-exception-predicate'
```

### 4. Retry on Conditional Predicate
```
curl 'http://localhost:8080/movies/4?retryType=retry-on-conditional-predicate'
```

### 5. Retry Using Exponential Backoff
```
curl 'http://localhost:8080/movies/3?retryType=retry-using-exponential-backoff'
```

### 6. Retry Using Randomized Wait
```
curl 'http://localhost:8080/movies/3?retryType=retry-using-randomized-wait'
```

### 7. Retry with Fallback
```
curl 'http://localhost:8080/movies/4?retryType=retry-with-fallback'
```

### 8. Retry with Custom Retry Configuration
```
curl 'http://localhost:8080/movies/3?retryType=retry-with-custom-config'
```

### 9. Retry with Event Details
```
curl 'http://localhost:8080/movies/3?retryType=retry-with-event-details'
```