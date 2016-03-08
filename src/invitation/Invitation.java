package invitation;

import com.guest.Address;
import com.guest.Name;

public interface Invitation {
    public String invite(String title, Name name, Address address);
}
