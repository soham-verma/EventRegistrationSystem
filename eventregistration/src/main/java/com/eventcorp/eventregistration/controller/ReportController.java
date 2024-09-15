package com.eventcorp.eventregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventcorp.eventregistration.model.EventReport;
import com.eventcorp.eventregistration.service.ReportService;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/events/{eventId}")
    public ResponseEntity<EventReport> getEventReport(@PathVariable Long eventId) {
        EventReport report = reportService.generateEventReport(eventId);
        return ResponseEntity.ok(report);
    }
}
