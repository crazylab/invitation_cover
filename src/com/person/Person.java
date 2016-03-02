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

    private String generateFullName(String name) {
        return gender.prefix() + " " + name;
    }

    public String representCasually() {
        return generateFullName(name.representCasually());
    }

    public String representFormally() {
        return generateFullName(name.representFormally());
    }
}
