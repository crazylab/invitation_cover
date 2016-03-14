package com.invitation.label;

import com.guest.Guest;
import com.invitation.name.NameFormat;

public class LabelGenerator {
    private Formatter addressFormat;

    private NameFormat nameFormat;

    public LabelGenerator(NameFormat nameFormat, Formatter addressFormat) {
        this.nameFormat = nameFormat;
        this.addressFormat = addressFormat;
    }

    public String generateLabel(Guest guest) {
        String name = guest.generateName(nameFormat);
        String address = guest.generateAddress(addressFormat);
        return genetateFinalLabel(name, address);
    }


    private String genetateFinalLabel(String name, String address) {
        int maxWidth = getMaxWidth(name.concat("\n" + address).split("\n"));
        String template = "+$dash+\n" +
                "| $name $n_pad|\n" +
                "|$dash|\n" +
                "| $city_state $cs_pad|\n" +
                "| country $c_pad|\n" +
                "+$dash+";
        return template.replace("$dash", new String(new char[maxWidth+2]).replace("\0", "-"))
                .replace("$name", name)
                .replace("$n_pad", new String(new char[maxWidth - name.length()]).replace("\0", " "))
                .replace("$city_state", address.split("\n")[0])
                .replace("$cs_pad", new String(new char[maxWidth - address.split("\n")[0].length()]).replace("\0", " "))
                .replace("country", address.split("\n")[1])
                .replace("$c_pad", new String(new char[maxWidth - address.split("\n")[1].length()]).replace("\0", " "));
    }

    private int getMaxWidth(String[] data) {
        int maxLength = 0;
        for (String s : data)
            maxLength = maxLength < s.length() ? s.length() : maxLength;
        return maxLength;
    }
}
