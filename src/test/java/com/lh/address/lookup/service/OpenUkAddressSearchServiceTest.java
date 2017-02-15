package com.lh.address.lookup.service;

import com.lh.address.lookup.domain.Address;
import com.lh.address.lookup.service.rest.dto.AddressDto;
import com.lh.address.lookup.service.rest.dto.OpenUkAddressSearchDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyCollection;
import static org.mockito.Matchers.anyMap;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

/**
 * Created by sergej on 13.2.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class OpenUkAddressSearchServiceTest {

    private static final String SEARCH_URL_OPEN_UK_ADDRESS = "https://alpha.openaddressesuk.org/addresses.json?postcode={postCode}";
    private static final String POST_CODE_DOWNING_STREET = "SW1A2AA";

    @Mock
    private RestTemplate restTemplate;
    @Mock
    private OpenUkAddressSearchDto openUkAddressSearchDto;
    @Mock
    private AddressDto addressDto;

    private List<Address> addresses;
    private OpenUkAddressSearchService searchService;

    @Before
    public void setUp() throws Exception {
        searchService = new OpenUkAddressSearchService(restTemplate, SEARCH_URL_OPEN_UK_ADDRESS);
    }

    @Test
    public void getAddresses() {
        givenOpenAddress();
        givenARestTemplate();
        whenICallGetFlights();
        flightsAreReturned();
    }

    private void givenARestTemplate() {
        when(restTemplate.getForObject(eq(SEARCH_URL_OPEN_UK_ADDRESS), eq(OpenUkAddressSearchDto.class), anyMap()) ).thenReturn(openUkAddressSearchDto);
    }

    private void givenOpenAddress() {
        when(openUkAddressSearchDto.getAddresses()).thenReturn(new AddressDto[]{addressDto});
    }

    private void whenICallGetFlights() {
        addresses = searchService.getAddressesByPostCode(POST_CODE_DOWNING_STREET);
    }

    private void flightsAreReturned() {
        assertThat(addresses.size(), is(1));
    }
}