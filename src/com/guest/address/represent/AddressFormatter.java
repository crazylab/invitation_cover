package com.guest.address.represent;

import com.guest.address.City;
import com.guest.address.Country;
import com.guest.address.State;

public interface AddressFormatter {
    String representAddress(City city, State state, Country country);
}
