package invitation.name;

public class FormalName implements NameFormat {

    @Override
    public String callWithTitle(String title, String firstName, String lastName) {
        String fullName = lastName.concat(", "+firstName);
        return title.concat(" "+fullName);
    }
}
