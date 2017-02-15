package com.travix.busyflights.controller;

import com.google.common.collect.Lists;
import com.travix.busyflights.controller.dto.FlightsSearchRequest;
import com.travix.busyflights.domain.Flight;
import com.travix.busyflights.service.FlightsSearchService;
import com.travix.busyflights.service.SearchCriteria;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by sergej on 13.2.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class FlightsSearchControllerTest {

    private static final String SUPPLIER_CRAZY_AIR = "CrazyAir";
    private static final String SUPPLIER_TOUGH_JET = "ToughJet";

    @Mock
    private FlightsSearchService searchService;
    @Mock
    private FlightsSearchRequest request;
    private FlightsSearchController controller;
    private Flight flight;
    private List<Flight> flights;

    @Before
    public void setUp() {
        controller = new FlightsSearchController(searchService);
    }

    @Test
    public void searchCrazyAir() {
        givenASearchService();
        whenICallSearchCrazyAir();
        dtosAreReturned();
    }

    private void givenASearchService() {
        flight = getFlight();
        List<Flight> flights = Lists.newArrayList(flight);
        when(searchService.getFlights(any(SearchCriteria.class))).thenReturn(flights);
    }

    private void whenICallSearchCrazyAir() {
        flights = controller.search(request);
    }

    private void dtosAreReturned() {
        assertThat(flights.size(), is(1));
        assertFlights(flights.get(0), flight);
    }

    private void assertFlights(Flight returnedFlight, Flight flight) {
        assertThat(returnedFlight.getAirLine(), is(flight.getAirLine()));
        assertThat(returnedFlight.getArrivalDate(), is(flight.getArrivalDate()));
        assertThat(returnedFlight.getDepartureDate(), is(flight.getDepartureDate()));
        assertThat(returnedFlight.getDepartureAirportCode(), is(flight.getDepartureAirportCode()));
        assertThat(returnedFlight.getDestinationAirportCode(), is(flight.getDestinationAirportCode()));
        assertThat(returnedFlight.getSupplier(), is(flight.getSupplier()));
        assertThat(returnedFlight.getFare(), is(flight.getFare()));
    }

    private Flight getFlight() {
        Flight flight = new Flight();
        flight.setDepartureDate(new Date());
        flight.setArrivalDate(new Date());
        flight.setAirLine("WhatEver");
        flight.setDestinationAirportCode("destination");
        flight.setDestinationAirportCode("origin");
        flight.setSupplier(SUPPLIER_CRAZY_AIR);
        flight.setFare(44d);
        return flight;
    }
}