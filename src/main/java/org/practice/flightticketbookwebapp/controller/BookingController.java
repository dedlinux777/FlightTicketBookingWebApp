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

@Controller
public class BookingController {
    @Autowired
    private IBookingService service;
    @PostMapping("/add-passenger")
    public String addPassenger(@ModelAttribute Passenger passenger, Model model){
        Integer ticket_id = service.registerPassenger(passenger);
        model.addAttribute("ticket_id", ticket_id);
        return "index";
    }

    @GetMapping("/passenger-form")
    public String getPassengerForm(Model model){
        model.addAttribute("passenger", new Passenger());
        return "booking-form";
    }
    @GetMapping("/ticket-form")
    public String getBookingForm(Model model){
        model.addAttribute("ticket", new Ticket());
        return "ticket-form";
    }

    @PostMapping("/book-ticket")
    public String bookFlightTicket(@ModelAttribute Ticket ticket){

        return "index";
    }


}
