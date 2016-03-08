package invitation.name;

public class CasualName implements NameRepresentation {

    @Override
    public String call(String firstName, String lastName) {
        return firstName.concat(" " + lastName);
    }
}
