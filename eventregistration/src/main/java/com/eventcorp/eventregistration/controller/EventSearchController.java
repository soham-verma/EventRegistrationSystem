package com.eventcorp.eventregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.eventcorp.eventregistration.model.Event;
import com.eventcorp.eventregistration.service.EventSearchService;

import java.util.List;

@RestController
@RequestMapping("/search")
public class EventSearchController {
    @Autowired
    private EventSearchService eventSearchService;

    @GetMapping("/name")
    public List<Event> searchEventsByName(@RequestParam String name) {
        return eventSearchService.searchEventsByName(name);
    }

    @GetMapping("/date")
    public List<Event> searchEventsByDate(@RequestParam String date) {
        return eventSearchService.searchEventsByDate(date);
    }

    @GetMapping("/location")
    public List<Event> searchEventsByLocation(@RequestParam String location) {
        return eventSearchService.searchEventsByLocation(location);
    }
}
