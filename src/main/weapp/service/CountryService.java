package main.weapp.service;

import main.weapp.bean.Country;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by krouns on 12/3/17.
 */
public class CountryService {


    static HashMap<Integer, Country> countryIdMap = getCountryIdMap();

    public CountryService() {
        super();

        if (countryIdMap == null) {
            countryIdMap = new HashMap<>();
            Country indiaCountry = new Country(1, "India", 10000);
            Country chinaCountry = new Country(4, "China", 20000);
            Country nepalCountry = new Country(3, "Nepal", 8000);
            Country bhutanCountry = new Country(2, "Bhutan", 7000);

            countryIdMap.put(1, indiaCountry);
            countryIdMap.put(4, chinaCountry);
            countryIdMap.put(3, nepalCountry);
            countryIdMap.put(2, bhutanCountry);


        }
    }
    public List<Country> getAllCountries() {

        List<Country> countries = new ArrayList<>(countryIdMap.values());
        return countries;

    }
    public Country getCountry(int id)
    {
        Country country= countryIdMap.get(id);
        return country;
    }
    public Country addCountry(Country country)
    {
        country.setId(getMaxId()+1);
        countryIdMap.put(country.getId(), country);
        return country;
    }

    public Country updateCountry(Country country)
    {
        if(country.getId()<=0)
            return null;
        countryIdMap.put(country.getId(), country);
        return country;

    }
    public void deleteCountry(int id)
    {
        countryIdMap.remove(id);
    }

    public static int getMaxId()
    {   int max=0;
        for (int id:countryIdMap.keySet()) {
            if(max<=id)
                max=id;

        }
        return max;
    }


    public static HashMap<Integer, Country> getCountryIdMap() {
        return countryIdMap;
    }

}
