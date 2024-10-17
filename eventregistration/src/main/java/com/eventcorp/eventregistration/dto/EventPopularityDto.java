package com.eventcorp.eventregistration.dto;


public class EventPopularityDto {
    private String eventName;
    private int registrations;
    private int likes;

    public EventPopularityDto(){}

    public EventPopularityDto(String eventName, int registrations, int likes) {
        this.eventName = eventName;
        this.registrations = registrations;
        this.likes = likes;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getRegistrations() {
        return registrations;
    }

    public void setRegistrations(int registrations) {
        this.registrations = registrations;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
