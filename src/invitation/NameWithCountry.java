package invitation;

import com.guest.Address;
import com.guest.Name;
import invitation.name.NameFormat;

public class NameWithCountry implements  Invitation{
    private NameFormat nameFormat;

    public NameWithCountry(NameFormat nameFormat) {
        this.nameFormat = nameFormat;
    }

    @Override
    public String invite(String title, Name name, Address address) {
        String nameWithHonorific = nameFormat.callWithTitle(title, name.getFirst(), name.getLast());
        return address.addCountryAtEnd(nameWithHonorific);
    }
}
