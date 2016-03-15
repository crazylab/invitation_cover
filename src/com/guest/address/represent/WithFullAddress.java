package com.guest.address.represent;

import com.guest.address.City;
import com.guest.address.Country;
import com.guest.address.State;

public class WithFullAddress implements AddressFormatter {

    @Override
    public String representAddress(City city, State state, Country country) {
        return String.format("%s, %s\n%s", city.name(), state.name(), country.name());
    }
}
