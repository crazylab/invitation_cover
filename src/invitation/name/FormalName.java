package invitation.name;

public class FormalName implements NameRepresentation {

    @Override
    public String call(String firstName, String lastName) {
        return lastName.concat(", " + firstName);
    }
}
