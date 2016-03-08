package invitation;

import com.person.Address;
import com.person.Name;

public class NameWithCountry implements  Invitation{

    @Override
    public String invite(String title, Name name, Address address) {
        String nameWithHonorific = name.call(title);
        return address.addCountryAtEnd(nameWithHonorific);
    }
}
