package com.lh.address.lookup.service;

import com.lh.address.lookup.domain.Address;
import com.lh.address.lookup.service.rest.dto.AddressDto;
import org.apache.http.client.HttpClient;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by sergej on 13.2.2017.
 */
//@RunWith(MockitoJUnitRunner.class)
public class OpenUkAddressSearchServiceTest {

    private static final String SEARCH_URL_OPEN_UK_ADDRESS = "https://alpha.openaddressesuk.org/addresses.json?postcode=SW1A2AA";
    private static final String POST_CODE_DOWNING_STREET = "SW1A2AA";

    //    @Mock
    private RestTemplate restTemplate;
    //    @Mock
    private AddressDto addressDto;

    private List<Address> addresses;
    private OpenUkAddressSearchService searchService;

    @Before
    public void setUp() throws Exception {
        restTemplate = new RestTemplate();
        searchService = new OpenUkAddressSearchService(restTemplate, SEARCH_URL_OPEN_UK_ADDRESS);
    }

    @Test
    public void getAddresses() {
        givenARestTemplate();
        whenICallGetFlights();
        flightsAreReturned();
    }

    private void givenARestTemplate() {
//        AddressDto[] crazyAirDtos = new AddressDto[]{addressDto};
//        when(restTemplate.getForObject(eq(SEARCH_URL_OPEN_UK_ADDRESS), any(AddressDto[].class), any(Object.class))).thenReturn(crazyAirDtos);
    }


    private void whenICallGetFlights() {
        addresses = searchService.getAddressesByPostCode(POST_CODE_DOWNING_STREET);
    }

    private void flightsAreReturned() {
        assertThat(addresses.size(), is(6));
    }
}