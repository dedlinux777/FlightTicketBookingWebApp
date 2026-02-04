package org.practice.flightticketbookwebapp.controller;

import org.practice.flightticketbookwebapp.model.Passenger;
import org.practice.flightticketbookwebapp.model.Ticket;
import org.practice.flightticketbookwebapp.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController {

    @Autowired
    private IBookingService service;

    // Page 1: Form to register passenger
    @GetMapping("/passenger-form")
    public String getPassengerForm(Model model){
        model.addAttribute("passenger", new Passenger());
        return "booking-form";
    }

    @PostMapping("/add-passenger")
    public String addPassenger(@ModelAttribute Passenger passenger, Model model){
        Integer ticket_id = service.registerPassenger(passenger);
        model.addAttribute("ticket_id", ticket_id);
        return "ticket-confirmation"; // Page showing the returned ticket ID
    }

    // Page 2: Form to input ticket number
    @GetMapping("/ticket-form")
    public String getTicketInputForm(Model model){
        return "ticket-lookup";
    }

    // Page 3: Display full ticket details
    @PostMapping("/view-ticket")
    public String viewTicket(@RequestParam("ticketNumber") Integer ticketNumber, Model model){
        Ticket ticket = service.getFullTicket(ticketNumber);
        model.addAttribute("ticket", ticket);
        return "display-ticket";
    }
}
