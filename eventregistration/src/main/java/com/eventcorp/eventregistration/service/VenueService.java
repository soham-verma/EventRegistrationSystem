package com.eventcorp.eventregistration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventcorp.eventregistration.model.Venue;
import com.eventcorp.eventregistration.repository.VenueRepository;

@Service
public class VenueService {
    @Autowired
    private VenueRepository venueRepository;

    public Venue createVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    public List<Venue> getAllVenues() {
        return venueRepository.findAll();
    }

    public Optional<Venue> getVenueById(Long id) {
        return venueRepository.findById(id);
    }

    public Venue updateVenue(Long id, Venue updatedVenue) {
        Venue venue = venueRepository.findById(id).orElseThrow(() -> new RuntimeException("Venue not found"));
        venue.setName(updatedVenue.getName());
        venue.setAddress(updatedVenue.getAddress());
        venue.setCapacity(updatedVenue.getCapacity());
        return venueRepository.save(venue);
    }

    public void deleteVenue(Long id) {
        venueRepository.deleteById(id);
    }
}
