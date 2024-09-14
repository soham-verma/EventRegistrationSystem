package com.eventcorp.eventregistration.model;

public class EventReport {
    private int totalRegistrations;
    private double totalRevenue;

    // Constructor
    public EventReport(int totalRegistrations, double totalRevenue) {
        this.totalRegistrations = totalRegistrations;
        this.totalRevenue = totalRevenue;
    }

    // Getters and Setters
    public int getTotalRegistrations() {
        return totalRegistrations;
    }

    public void setTotalRegistrations(int totalRegistrations) {
        this.totalRegistrations = totalRegistrations;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}

