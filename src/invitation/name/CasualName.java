package invitation.name;

public class CasualName implements NameFormat {

    @Override
    public String callWithTitle(String title, String firstName, String lastName) {
        String fullName = firstName.concat(" "+lastName);
        return title.concat(" "+fullName);
    }
}
