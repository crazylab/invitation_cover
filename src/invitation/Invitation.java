package invitation;

import com.person.Address;
import com.person.Name;

public interface Invitation {
    public String invite(String title, Name name, Address address);
}
