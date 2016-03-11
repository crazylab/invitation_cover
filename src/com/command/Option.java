package com.command;

import com.invitation.label.InvitationFormatter;
import com.invitation.label.WithAge;
import com.invitation.label.WithCountry;

public class Option {
    private String option;
    private String parameter;

    public Option(String option, String parameter) {
        this.option = option;
        this.parameter = parameter;
    }

    public InvitationFormatter getFormatter(){
        switch (option.toUpperCase()){
            case "--AGE" : return new WithAge();
            case "--COUNTRY" : return new WithCountry();
        }
        return null;
    }

    public String getParameter(){
        return parameter;
    }
}
