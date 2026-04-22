
import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private Map<String, Contact> contacts = new HashMap<>();

    public boolean addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactID())) {
            return false;
        }
        contacts.put(contact.getContactID(), contact);
        return true;
    }

    public boolean deleteContact(String contactID) {
        return contacts.remove(contactID) != null;
    }

    public boolean updateFirstName(String contactID, String firstName) {
        Contact c = contacts.get(contactID);
        if (c == null) return false;
        c.setFirstName(firstName);
        return true;
    }

    public boolean updateLastName(String contactID, String lastName) {
        Contact c = contacts.get(contactID);
        if (c == null) return false;
        c.setLastName(lastName);
        return true;
    }

    public boolean updatePhone(String contactID, String phone) {
        Contact c = contacts.get(contactID);
        if (c == null) return false;
        c.setPhone(phone);
        return true;
    }

    public boolean updateAddress(String contactID, String address) {
        Contact c = contacts.get(contactID);
        if (c == null) return false;
        c.setAddress(address);
        return true;
    }

    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}
