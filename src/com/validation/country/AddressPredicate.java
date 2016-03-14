package com.validation.country;

import com.guest.address.City;
import com.guest.address.Country;
import com.guest.address.State;

public interface AddressPredicate {
    boolean checkValidity(City city, State state, Country country);
}
