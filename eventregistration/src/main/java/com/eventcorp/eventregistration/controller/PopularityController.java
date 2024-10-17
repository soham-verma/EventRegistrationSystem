package com.eventcorp.eventregistration.controller;

import com.eventcorp.eventregistration.service.PopularityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PopularityController {

    @Autowired
    private PopularityService popularityService;

    @GetMapping("/admin/popularity")
    public Map<String, Integer> getRealTimePopularity() {
        return popularityService.getAllEventPopularity();
    }
}
