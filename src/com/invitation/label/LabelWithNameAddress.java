package com.invitation.label;

import com.guest.Gender;
import com.guest.address.Address;
import com.guest.address.represent.AddressFormatter;
import com.guest.name.Name;
import com.guest.name.represent.NameFormatter;

public class LabelWithNameAddress implements LabelFormatter{

    private final NameFormatter nameFormatter;
    private final AddressFormatter addressFormatter;

    public LabelWithNameAddress(NameFormatter nameFormatter, AddressFormatter addressFormatter) {
        this.nameFormatter = nameFormatter;
        this.addressFormatter = addressFormatter;
    }

//    @Override
    public String generateLabel(Name name, Gender gender, Address address) {
        String nameFormat = name.callWithTitle(gender.getHonorific(), nameFormatter);
        String addressFormat = address.representAddress(addressFormatter);
        return genetateFinalLabel(nameFormat, addressFormat);
    }


    private String genetateFinalLabel(String name, String address) {
        int maxWidth = getMaxWidth(name.concat("\n" + address).split("\n"));
        String template = "+$dash+\n" +
                "| $name $n_pad|\n" +
                "|$dash|\n" +
                "| $city_state $cs_pad|\n" +
                "| country $c_pad|\n" +
                "+$dash+";

        String outerBorder = repeatChar("-", maxWidth+2);
        String city_state = address.split("\n")[0];
        String country = address.split("\n")[1];
        return template.replace("$dash", outerBorder)
                .replace("$name", name)
                .replace("$n_pad", repeatChar(" ", maxWidth - name.length()))
                .replace("$city_state", city_state)
                .replace("$cs_pad", repeatChar(" ", maxWidth - city_state.length()))
                .replace("country", country)
                .replace("$c_pad", repeatChar(" ", maxWidth - country.length()));
    }

    private String repeatChar(String character, int repeat){
        return new String(new char[repeat]).replace("\0", character);
    }
    private int getMaxWidth(String[] data) {
        int maxLength = 0;
        for (String s : data)
            maxLength = maxLength < s.length() ? s.length() : maxLength;
        return maxLength;
    }
}
