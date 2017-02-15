package com.travix.busyflights.service;

import com.google.common.annotations.VisibleForTesting;
import com.travix.busyflights.domain.Flight;
import com.travix.busyflights.service.rest.dto.CrazyAirFlightDto;
import com.travix.busyflights.service.rest.dto.CrazyAirSearchRequest;
import com.travix.busyflights.service.rest.dto.ToughJetFlightDto;
import com.travix.busyflights.service.rest.dto.ToughJetSearchRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sergej on 13.2.2017.
 */
@Service
public class FlightsSearchService {

    private static final String SUPPLIER_CRAZY_AIR = "CrazyAir";
    private static final String SUPPLIER_TOUGH_JET = "ToughJet";
    private static final Logger LOGGER = LoggerFactory.getLogger(FlightsSearchService.class);

    private RestTemplate restTemplate;
    private String crazyAirSearchUrl;
    private String toughJetSearchUrl;

    @Autowired
    public FlightsSearchService(@Value("${crazyAirSearchUrl}") String crazyAirSearchUrl,
                                @Value("${toughJetSearchUrl}") String toughJetSearchUrl) {
        this.crazyAirSearchUrl = crazyAirSearchUrl;
        this.toughJetSearchUrl = toughJetSearchUrl;
        this.restTemplate = new RestTemplate();
    }

    @VisibleForTesting
    FlightsSearchService(RestTemplate restTemplate,
                         String crazyAirSearchUrl,
                         String toughJetSearchUrl) {
        this.restTemplate = restTemplate;
        this.crazyAirSearchUrl = crazyAirSearchUrl;
        this.toughJetSearchUrl = toughJetSearchUrl;
    }

    public List<Flight> getFlights(SearchCriteria sc) {
        List<Flight> crazyAirFlights = getCrazyAirFlights(sc);
        List<Flight> toughJetFlights = getToughJetFlights(sc);

        List<Flight> flights = new ArrayList<>();
        flights.addAll(crazyAirFlights);
        flights.addAll(toughJetFlights);
        return flights;
    }

    private List<Flight> getCrazyAirFlights(SearchCriteria sc) {
        CrazyAirSearchRequest request = toCrazyAirRequest(sc);
        LOGGER.debug("Sending request to " + SUPPLIER_CRAZY_AIR + request);
        CrazyAirFlightDto[] dtos = restTemplate.postForObject(crazyAirSearchUrl, request, CrazyAirFlightDto[].class);
        LOGGER.debug("Processing response from " + SUPPLIER_CRAZY_AIR, dtos);
        return Arrays.stream(dtos).map(dto -> toFlight(dto)).collect(Collectors.toList());
    }

    private List<Flight> getToughJetFlights(SearchCriteria sc) {
        ToughJetSearchRequest request = toToughJetRequest(sc);
        LOGGER.debug("Sending request to " + SUPPLIER_TOUGH_JET + request);
        ToughJetFlightDto[] dtos = restTemplate.postForObject(toughJetSearchUrl, request, ToughJetFlightDto[].class);
        LOGGER.debug("Processing response from " + SUPPLIER_TOUGH_JET, dtos);
        return Arrays.stream(dtos).map(dto -> toFlight(dto)).collect(Collectors.toList());
    }

    private CrazyAirSearchRequest toCrazyAirRequest(SearchCriteria sc) {
        CrazyAirSearchRequest request = new CrazyAirSearchRequest();
        request.setOrigin(sc.getOrigin());
        request.setDestination(sc.getDestination());
        request.setDepartureDate(sc.getDepartureDate());
        request.setReturnDate(sc.getReturnDate());
        request.setNumberOfPassengers(sc.getNumberOfPassengers());

        return request;
    }

    private ToughJetSearchRequest toToughJetRequest(SearchCriteria sc) {
        ToughJetSearchRequest request = new ToughJetSearchRequest();
        request.setOrigin(sc.getOrigin());
        request.setDestination(sc.getDestination());
        request.setDepartureDate(sc.getDepartureDate());
        request.setReturnDate(sc.getReturnDate());
        request.setNumberOfPassengers(sc.getNumberOfPassengers());
        return request;
    }

    private Flight toFlight(CrazyAirFlightDto dto) {
        Flight flight = new Flight();
        flight.setAirLine(dto.getAirLine());
        flight.setDepartureDate(dto.getDepartureDate());
        flight.setArrivalDate(dto.getArrivalDate());
        flight.setDepartureAirportCode(dto.getDepartureAirportCode());
        flight.setDestinationAirportCode(dto.getDestinationAirportCode());
        flight.setFare(dto.getPrice());
        flight.setSupplier(SUPPLIER_CRAZY_AIR);
        return flight;
    }

    private Flight toFlight(ToughJetFlightDto dto) {
        Flight flight = new Flight();
        flight.setAirLine(dto.getAirLine());
        flight.setDepartureDate(dto.getDepartureDate());
        flight.setArrivalDate(dto.getReturnDate());
        flight.setDepartureAirportCode(dto.getDepartureAirportCode());
        flight.setDestinationAirportCode(dto.getDestinationAirportCode());
        flight.setFare(dto.getPrice());
        flight.setSupplier(SUPPLIER_TOUGH_JET);
        return flight;
    }


}
