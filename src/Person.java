public class Person {
    private Name name;

    private String gender;

    private int age;

    private Address address;

    public Person(String firstName, String lastName, String gender, int age, String city, String state, String country) {
        this.name = new Name(firstName, lastName, gender);
        this.gender = gender;
        this.age = age;
        this.address = new Address(city, state, country);
    }

    public String representInvitation() {
        return name.toString();
    }
}
