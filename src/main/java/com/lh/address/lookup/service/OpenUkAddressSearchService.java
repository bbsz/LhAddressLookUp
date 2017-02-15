package com.lh.address.lookup.service;

import com.google.common.annotations.VisibleForTesting;
import com.lh.address.lookup.domain.Address;
import com.lh.address.lookup.service.rest.dto.AddressDto;
import com.lh.address.lookup.service.rest.dto.OpenUkAddressSearchDto;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by sergej on 13.2.2017.
 */
@Service
public class OpenUkAddressSearchService {

    private RestTemplate restTemplate;
    private String openAddressSearchByPostCodeUrl;

    @Autowired
    public OpenUkAddressSearchService(@Value("${openUkAddressSearch.byPostCode}") String openUkAddressSearchUrl) {
        this.openAddressSearchByPostCodeUrl = openUkAddressSearchUrl;
        this.restTemplate = new RestTemplate();
    }

    @VisibleForTesting
    OpenUkAddressSearchService(RestTemplate restTemplate, String openAddressSearchByPostCodeUrl) {
        this.openAddressSearchByPostCodeUrl = openAddressSearchByPostCodeUrl;
        this.restTemplate = restTemplate;
        this.restTemplate.setRequestFactory(getRequestFactory());
    }

    public List<Address> getAddressesByPostCode(String postCode) {
        Map<String, String> params = new HashMap<>();
        params.put("postCode", postCode);
        OpenUkAddressSearchDto dto = restTemplate.getForObject(openAddressSearchByPostCodeUrl, OpenUkAddressSearchDto.class);
        return Arrays.stream(dto.getAddresses()).map(addressDto -> toAddress(addressDto)).collect(Collectors.toList());
    }

    private Address toAddress(AddressDto dto) {
        Address address = new Address();
        return address;
    }

    public HttpComponentsClientHttpRequestFactory getRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setHttpClient(getHttpClient());
        return factory;
    }

    private HttpClient getHttpClient() {
        SSLContext sslContext = getSslContext();
        PoolingHttpClientConnectionManager connMgr = getConnectionManager(sslContext);

        HttpClientBuilder b = HttpClientBuilder.create();
        b.setSslcontext(sslContext);
        b.setConnectionManager(connMgr);
        return b.build();
    }

    private PoolingHttpClientConnectionManager getConnectionManager(SSLContext sslContext) {
        SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext, new NoopHostnameVerifier());
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", sslSocketFactory)
                .build();
        return new PoolingHttpClientConnectionManager(socketFactoryRegistry);
    }

    private SSLContext getSslContext() {
        try {
            SSLContextBuilder contextBuilder = new SSLContextBuilder();
            contextBuilder.loadTrustMaterial(null, (x509Certificates, allowAll) -> true).build();
            return contextBuilder.build();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
