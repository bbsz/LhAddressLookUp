package com.travix.busyflights.service;

import com.travix.busyflights.domain.Flight;
import com.travix.busyflights.service.rest.dto.CrazyAirFlightDto;
import com.travix.busyflights.service.rest.dto.CrazyAirSearchRequest;
import com.travix.busyflights.service.rest.dto.ToughJetFlightDto;
import com.travix.busyflights.service.rest.dto.ToughJetSearchRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

/**
 * Created by sergej on 13.2.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class FlightsSearchServiceTest {

    private static final String ORIGIN = "LDN";
    private static final String DESTINATION = "BRB";
    private static final int NUMBER_OF_PASSENGERS = 4;
    private static final String SEARCH_URL_CRAZY_AIR = "http://localhost:8080/flightsSearch/crayzAir";
    private static final String SEARCH_URL_TOUGH_JET = "http://localhost:8080/flightsSearch/toughJet";

    @Mock
    private RestTemplate restTemplate;
    @Mock
    private CrazyAirFlightDto crazyAirFlightDto;
    @Mock
    private ToughJetFlightDto toughJetFlightDto;
    private SearchCriteria searchCriteria;
    private List<Flight> flights;
    private FlightsSearchService searchService;

    @Before
    public void setUp() {
        searchService = new FlightsSearchService(restTemplate, SEARCH_URL_CRAZY_AIR, SEARCH_URL_TOUGH_JET);
    }

    @Test
    public void getFlights() {
        givenARestTemplate();
        givenASearchCriteria();
        whenICallGetFlights();
        flightsAreReturned();
    }

    private void givenARestTemplate() {
        CrazyAirFlightDto[] crazyAirList = new CrazyAirFlightDto[]{crazyAirFlightDto};
        ToughJetFlightDto[] toughJetList = new ToughJetFlightDto[]{toughJetFlightDto};
        when(restTemplate.postForObject(eq(SEARCH_URL_CRAZY_AIR), any(CrazyAirSearchRequest.class), any(Class.class))).thenReturn(crazyAirList);
        when(restTemplate.postForObject(eq(SEARCH_URL_TOUGH_JET), any(ToughJetSearchRequest.class), any(Class.class))).thenReturn(toughJetList);
    }

    private void givenASearchCriteria() {
        searchCriteria = new SearchCriteria();
        searchCriteria.setOrigin(ORIGIN);
        searchCriteria.setDestination(DESTINATION);
        searchCriteria.setDepartureDate(toDate(2017, 3, 14));
        searchCriteria.setReturnDate(toDate(2017, 3, 21));
        searchCriteria.setNumberOfPassengers(NUMBER_OF_PASSENGERS);
    }

    private void whenICallGetFlights() {
        flights = searchService.getFlights(searchCriteria);
    }

    private void flightsAreReturned() {
        assertThat(flights.size(), is(2));
    }

    private Date toDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month - 1, day);
        return cal.getTime();
    }

}