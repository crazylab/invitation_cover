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

    private String addPrefix(String fullname){
        return gender.getPrefix() + " " + fullname;
    }

    public String representInvitation() {
        return addPrefix(name.toString());
    }
}
