package invitation.name;

public class FormalName implements Caller {

    @Override
    public String call(String title, String firstName, String lastName) {
        return String.format("%s %s, %s", title, lastName, firstName);
    }
}
