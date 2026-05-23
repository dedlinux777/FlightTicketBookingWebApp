# Building these two applications—the **TicketBookingAPI** (the service provider) and the **FlightTicketBookWebApp** (the consumer)—demonstrates a classic **Business-to-Business (B2B)** communication model in microservices architecture.

### 1. The B2B Communication Concept

In this architecture, your applications play two distinct roles:

* **Service Provider (TicketBookingAPI):** A standalone RESTful API that exposes endpoints for data persistence and business logic (e.g., booking tickets, registering passengers).
* **Service Consumer (FlightTicketBookWebApp):** A web application that provides a User Interface (JSP) to the end-customer and communicates with the provider using HTTP client tools.

---

### 2. Standalone API Design (The Provider)

You learned how to build a robust backend using the standard Spring Boot layers.

#### **A. The Resource (Controller)**

The controller defines the entry points for the B2B communication. It uses `@RequestBody` to receive data and `@PathVariable` for specific resource lookups.

**Example: TicketBookingAPI Controller Snippet**

```java
@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private ITicketService service;

    // B2B Endpoint for booking a ticket
    @PostMapping("/book")
    public ResponseEntity<Ticket> bookTicket(@RequestBody Ticket ticket) {
        Ticket booked = service.bookTicket(ticket);
        return new ResponseEntity<>(booked, HttpStatus.CREATED);
    }

    // B2B Endpoint for retrieving a ticket
    @GetMapping("/get/{ticketNumber}")
    public ResponseEntity<Ticket> getTicket(@PathVariable Integer ticketNumber) {
        Ticket ticket = service.getTicketDetails(ticketNumber);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }
}

```
### 3. Communicating from the Web App (The Consumer)

The core of B2B communication is choosing the right HTTP client. You implemented both the traditional and modern approaches.

#### **A. RestTemplate (Synchronous)**

`RestTemplate` is a synchronous client where the application waits (blocks) for the response from the API before moving to the next line of code.

**Implementation Example:**

```java
@Service
public class BookingServiceImpl implements IBookingService {

    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8585/ticket_api/api";

    @Override
    public Integer registerPassenger(Passenger passenger) {
        String url = BASE_URL + "/passengers/register";
        // B2B Call: Sending Passenger object to API and receiving saved object back
        Passenger savedPassenger = restTemplate.postForObject(url, passenger, Passenger.class);
        return savedPassenger.getPassenger_id();
    }
}

```

*Source:*

#### **B. WebClient (Modern & Reactive/ Asynchronous)**

`WebClient` is the modern, non-blocking replacement for `RestTemplate`. Even when used in a blocking way (via `.block()`), it provides a more fluent API for complex requests.

**Implementation Example:**

```java
@Override
public Ticket getFullTicket(Integer ticketNumber) {
    String url = BASE_URL + "/tickets/get/" + ticketNumber;
    
    return webClientBuilder.build()
            .get()
            .uri(url)
            .retrieve()
            .bodyToMono(Ticket.class) // Maps JSON response to Ticket model
            .block(); // Synchronizes the call to return data to the JSP
}

```
---
### 4. The Flow of Data

Through this project, you traced the complete lifecycle of a request:

1. **User to Consumer:** A user fills out a JSP form (`booking-form.jsp`).
2. **Consumer to Business (B2B):** The `BookingController` triggers the service, which uses `RestTemplate` to send an HTTP POST to the standalone `TicketBookingAPI`.
3. **Database Persistence:** The API saves the data to MySQL via `JpaRepository` and returns the generated ID.
4. **Reporting Back:** The Web App receives the ID and displays it to the user on the `ticket-confirmation.jsp` page.

