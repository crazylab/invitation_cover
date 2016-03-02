package com.person;

public class Person {
    private Name name;

    private Gender gender;

    private int age;

    private Address address;

    public Person(Name name, Gender gender, int age, Address address) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    private String representInvitation(String fullname) {
        String template = "prefix name, country";
        return template
                    .replace("prefix", gender.prefix())
                    .replace("name", fullname)
                    .replace("country", address.getCountry());
    }

    public String representCasually() {
        return representInvitation(name.representCasually());
    }

    public String representFormally() {
        return representInvitation(name.representFormally());
    }
}
