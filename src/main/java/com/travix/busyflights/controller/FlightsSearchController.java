package com.travix.busyflights.controller;

import com.travix.busyflights.controller.dto.FlightsSearchRequest;
import com.travix.busyflights.domain.Flight;
import com.travix.busyflights.service.SearchCriteria;
import com.travix.busyflights.service.FlightsSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by sergej on 13.2.2017.
 */
@RestController
@RequestMapping("busyFlights/")
public class FlightsSearchController {

    private FlightsSearchService searchService;

    @Autowired
    public FlightsSearchController(FlightsSearchService searchService) {
        this.searchService = searchService;
    }

    @RequestMapping(value = "search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Flight> search(@Valid @RequestBody FlightsSearchRequest request) {
        SearchCriteria criteria = toSearchCriteria(request);
        List<Flight> flights = searchService.getFlights(criteria);
        return flights;
    }

    private SearchCriteria toSearchCriteria(FlightsSearchRequest request) {
        SearchCriteria criteria = new SearchCriteria();
        criteria.setDepartureDate(request.getDepartureDate());
        criteria.setReturnDate(request.getReturnDate());
        criteria.setDestination(request.getDestination());
        criteria.setOrigin(request.getOrigin());
        criteria.setNumberOfPassengers(request.getNumberOfPassengers());

        return criteria;
    }
}
