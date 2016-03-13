package com.validation;

import com.guest.Address;
import com.guest.Age;

public interface Validator {
    boolean isAllowed(Age age, Address address);
}
