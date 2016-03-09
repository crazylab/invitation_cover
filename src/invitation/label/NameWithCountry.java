package invitation.label;

import com.guest.Address;
import com.guest.Age;
import com.guest.Gender;
import com.guest.Name;
import invitation.name.Caller;

public class NameWithCountry implements InvitationPrinter {
    private Caller caller;

    public NameWithCountry(Caller caller) {
        this.caller = caller;
    }

    @Override
    public String invite(Name name, Gender gender, Age age, Address address) {
        name.setCaller(caller);
        String nameWithHonorific = name.call(gender.getHonorific());
        return address.addCountryAtTheEnd(nameWithHonorific);
    }
}
