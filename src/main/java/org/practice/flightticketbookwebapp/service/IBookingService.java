package org.practice.flightticketbookwebapp.service;

import org.practice.flightticketbookwebapp.model.Passenger;
import org.practice.flightticketbookwebapp.model.Ticket;

public interface IBookingService {
    public Integer registerPassenger(Passenger passenger);
    public Ticket getFullTicket(Integer id);
}
