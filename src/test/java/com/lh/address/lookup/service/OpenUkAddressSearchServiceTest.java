package com.lh.address.lookup.service;

import com.lh.address.lookup.domain.Address;
import com.lh.address.lookup.service.rest.dto.OpenUkAddressDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by sergej on 13.2.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class OpenUkAddressSearchServiceTest {

    private static final String SEARCH_URL_OPEN_UK_ADDRESS = "https://alpha.openaddressesuk.org/addresses.json?postcode={postCode}";
    private static final String POST_CODE_DOWNING_STREET = "SW1A2AA";

    //    @Mock
    private RestTemplate restTemplate;
    //    @Mock
    private OpenUkAddressDto openUkAddressDto;

    private List<Address> addresses;
    private OpenUkAddressSearchService searchService;

    @Before
    public void setUp() {
        searchService = new OpenUkAddressSearchService(restTemplate, SEARCH_URL_OPEN_UK_ADDRESS);
    }

    @Test
    public void getAddresses() {
        givenARestTemplate();
        whenICallGetFlights();
        flightsAreReturned();
    }

    private void givenARestTemplate() {
//        OpenUkAddressDto[] crazyAirDtos = new OpenUkAddressDto[]{openUkAddressDto};
//        when(restTemplate.getForObject(eq(SEARCH_URL_OPEN_UK_ADDRESS), any(OpenUkAddressDto[].class), any(Object.class))).thenReturn(crazyAirDtos);
        restTemplate = new RestTemplate();
    }


    private void whenICallGetFlights() {
        addresses = searchService.getAddressesByPostCode(POST_CODE_DOWNING_STREET);
    }

    private void flightsAreReturned() {
        assertThat(addresses.size(), is(2));
    }
}