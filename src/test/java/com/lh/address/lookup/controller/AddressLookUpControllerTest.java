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
    private Address address;
    private List<Address> addresses;

    @Before
    public void setUp() {
        controller = new AddressLookUpController(searchService);
    }

    @Test
    public void searchAddresses() {
        givenASearchService();
        whenICallSearchCrazyAir();
        dtosAreReturned();
    }

    private void givenASearchService() {
        address = getAddress();
        List<Address> flights = Lists.newArrayList(address);
        when(searchService.getAddressesByPostCode(anyString())).thenReturn(flights);
    }

    private void whenICallSearchCrazyAir() {
        addresses = controller.search(POST_CODE_DOWNING_STREET);
    }

    private void dtosAreReturned() {
        assertThat(addresses.size(), is(1));
        assertAddresses(addresses.get(0), address);
    }

    private void assertAddresses(Address returnAddress, Address address) {
        assertThat(returnAddress.getHouseNumber(), is(address.getHouseNumber()));
        assertThat(returnAddress.getStreet(), is(address.getStreet()));
        assertThat(returnAddress.getTown(), is(address.getTown()));
        assertThat(returnAddress.getPostCode(), is(address.getPostCode()));
    }

    private Address getAddress() {
        Address address = new Address();
        address.setHouseNumber("houseNumber");
        address.setStreet("Street");
        address.setTown("Town");
        address.setPostCode("PostCode");
        return address;
    }
}