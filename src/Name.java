public class Name {
    private String first;

    private String last;

    public Name(String firstName, String lastName) {
        this.first = firstName;
        this.last = lastName;
    }

    @Override
    public String toString() {
        return firstNameFirst();
    }

    public String firstNameFirst() {
        return first + " " + last;
    }

    public String lastNameFirst() {
        return last + ", " + first;
    }
}
