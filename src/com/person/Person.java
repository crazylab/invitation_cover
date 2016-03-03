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

    public String getFormalName(){
        return name.representFormally();
    }

    public String getCasulaName(){
        return name.representCasually();
    }

    public String getTitle(){
        return gender.getTitle();
    }

    public String getCountry(){
        return address.getCountry();
    }
}
