package represent;

import com.person.Person;

public class Invitation {
    private Person person;

    public Invitation(Person person) {
        this.person = person;
    }

    private String createInvitation(String fullname) {
        String invitationTemplate = "title fullname, country";
        return invitationTemplate
                .replace("title", person.getTitle())
                .replace("fullname", fullname)
                .replace("country", person.getCountry());
    }

    public String formally() {
        return createInvitation(person.getFormalName());
    }

    public String casully() {
        return createInvitation(person.getCasulaName());
    }
}
