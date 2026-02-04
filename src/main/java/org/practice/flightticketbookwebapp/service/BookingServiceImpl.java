package org.practice.flightticketbookwebapp.service;

import org.practice.flightticketbookwebapp.model.Passenger;
import org.practice.flightticketbookwebapp.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class BookingServiceImpl implements IBookingService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    private final String BASE_URL = "http://localhost:8485/ticket_api/api";

    @Override
    public Integer registerPassenger(Passenger passenger) {
        String url = BASE_URL+"/tickets/book";
        Ticket savedTicket = restTemplate.postForObject(url, passenger, Ticket.class);
        return savedTicket.getTicketNumber();
    }

    @Override
    public Ticket getFullTicket(Integer ticketNumber) {
        // Using WebClient to call Ticket Retrieval API
        String url = BASE_URL + "/tickets/get/" + ticketNumber;
        return webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(Ticket.class)
                .block(); // .block() makes it synchronous for the JSP response
    }
}