package com.lh.address.lookup.controller;

import com.google.common.collect.Lists;
import com.lh.address.lookup.domain.Address;
import com.lh.address.lookup.service.OpenUkAddressSearchService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by sergej on 13.2.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class AddressLookUpControllerTest {

    private static final String POST_CODE_DOWNING_STREET = "SW1A2AA";

    @Mock
    private OpenUkAddressSearchService searchService;
    private AddressLookUpController controller;
    private Address flight;
    private List<Address> flights;

    @Before
    public void setUp() {
        controller = new AddressLookUpController(searchService);
    }

    @Test
    public void searchCrazyAir() {
        givenASearchService();
        whenICallSearchCrazyAir();
        dtosAreReturned();
    }

    private void givenASearchService() {
        flight = getAddress();
        List<Address> flights = Lists.newArrayList(flight);
        when(searchService.getAddressesByPostCode(anyString())).thenReturn(flights);
    }

    private void whenICallSearchCrazyAir() {
        flights = controller.search(POST_CODE_DOWNING_STREET);
    }

    private void dtosAreReturned() {
        assertThat(flights.size(), is(1));
        assertFlights(flights.get(0), flight);
    }

    private void assertFlights(Address returnedFlight, Address flight) {
//        assertThat(returnedFlight.getAirLine(), is(flight.getAirLine()));
//        assertThat(returnedFlight.getArrivalDate(), is(flight.getArrivalDate()));
//        assertThat(returnedFlight.getDepartureDate(), is(flight.getDepartureDate()));
//        assertThat(returnedFlight.getDepartureAirportCode(), is(flight.getDepartureAirportCode()));
//        assertThat(returnedFlight.getDestinationAirportCode(), is(flight.getDestinationAirportCode()));
//        assertThat(returnedFlight.getSupplier(), is(flight.getSupplier()));
//        assertThat(returnedFlight.getFare(), is(flight.getFare()));
    }

    private Address getAddress() {
        Address flight = new Address();
        return flight;
    }
}