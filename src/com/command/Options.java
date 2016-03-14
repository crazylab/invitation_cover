package com.command;

import com.validation.Validator;
import com.validation.age.OlderThan;
import com.validation.age.ValidateByAge;
import com.validation.country.FromCountry;
import com.validation.country.ValidateByCountry;

public enum Options {
    AGEABOVE(){
        public Validator getValidator(String age){
            int ageInNumber = Integer.parseInt(age);
            return new ValidateByAge(new OlderThan(ageInNumber));
        }
    },
    COUNTRY(){
        public Validator getValidator(String country){
            return new ValidateByCountry(new FromCountry(country));
        }
    };

    public abstract Validator getValidator(String validationData);
}
