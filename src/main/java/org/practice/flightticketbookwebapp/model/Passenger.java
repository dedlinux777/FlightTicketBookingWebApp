package org.practice.flightticketbookwebapp.model;

public class Passenger {
    private Integer passenger_id;
    private String name;
    private String passport_no;
    private String arrival;
    private String dateOfJourney;

    public Passenger() {
    }

    public Passenger(Integer passenger_id, String name, String passport_no, String arrival, String dateOfJourney) {
        this.passenger_id = passenger_id;
        this.name = name;
        this.passport_no = passport_no;
        this.arrival = arrival;
        this.dateOfJourney = dateOfJourney;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passenger_id=" + passenger_id +
                ", name='" + name + '\'' +
                ", passport_no='" + passport_no + '\'' +
                ", arrival='" + arrival + '\'' +
                ", dateOfJourney='" + dateOfJourney + '\'' +
                '}';
    }

    public Integer getPassenger_id() {
        return passenger_id;
    }

    public void setPassenger_id(Integer passenger_id) {
        this.passenger_id = passenger_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport_no() {
        return passport_no;
    }

    public void setPassport_no(String passport_no) {
        this.passport_no = passport_no;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDateOfJourney() {
        return dateOfJourney;
    }

    public void setDateOfJourney(String dateOfJourney) {
        this.dateOfJourney = dateOfJourney;
    }
}
