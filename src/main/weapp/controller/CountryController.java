package main.weapp.controller;

import main.weapp.bean.Country;
import main.weapp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * Created by krouns on 12/3/17.
 */
@RestController
public class CountryController {

    CountryService countryService = new CountryService();
    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/countries", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Country> getAllCountries() {
        List<Country> countries = countryService.getAllCountries();
        return countries;
    }

    @RequestMapping(value = "/country/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Country getCountryById(@PathVariable int id) {
        return countryService.getCountry(id);
    }

    @RequestMapping(value = "/countries", method = RequestMethod.POST, headers = "Accept=application/json")
    public Country addCountry(@RequestBody Country country) {
        return countryService.addCountry(country);
    }

    @RequestMapping(value = "/countries", method = RequestMethod.PUT, headers = "Accept=application/json")
    public Country updateCountry(@RequestBody Country country) {
        return countryService.updateCountry(country);

    }

    @RequestMapping(value = "/country/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void deleteCountry(@PathVariable("id") int id) {
        countryService.deleteCountry(id);

    }


}
