package com.lh.address.lookup.controller;

import com.lh.address.lookup.domain.Address;
import com.lh.address.lookup.service.OpenUkAddressSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by sergej on 15.2.2017.
 */
@RestController
@RequestMapping("addressLookUp/")
public class AddressLookUpController {
    private OpenUkAddressSearchService searchService;

    @Autowired
    public AddressLookUpController(OpenUkAddressSearchService searchService) {
        this.searchService = searchService;
    }

    @RequestMapping(value = "streetNamesByPostCode", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> searchStreetNamesByPostCode(@RequestParam("postCode") String postCode) {
        List<Address> addresses = searchAddressesByPostCode(postCode);
        return processByFunction(addresses, (address -> address.getStreet().trim()));
    }

    @RequestMapping(value = "streetAddressesByPostCode", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> searchStreetAddressesByPostCode(@RequestParam("postCode") String postCode) {
        List<Address> addresses = searchAddressesByPostCode(postCode);
        return processByFunction(addresses, (address -> address.getStreetAddress().trim()));
    }

    @RequestMapping(value = "addressesByPostCode", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Address> searchAddressesByPostCode(@RequestParam("postCode") String postCode) {
        return searchService.getAddressesByPostCode(postCode);
    }

    private <T, R> List<R> processByFunction(List<T> addresses, Function<T, R> function) {
        List<R> streetNames = new ArrayList<>();
        for (T t : addresses) {
            R result = function.apply(t);
            if (!streetNames.contains(result)) {
                streetNames.add(result);
            }
        }
        return streetNames;
    }

}
