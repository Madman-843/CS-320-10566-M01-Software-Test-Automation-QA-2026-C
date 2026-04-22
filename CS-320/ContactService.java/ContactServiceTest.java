
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    public void setup() {
        service = new ContactService();
        service.addContact(new Contact("1", "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    public void testAddContact() {
        assertTrue(service.addContact(new Contact("2", "Jane", "Smith", "0987654321", "456 Oak St")));
        assertFalse(service.addContact(new Contact("1", "Dup", "Test", "1111111111", "111 Elm St"))); // duplicate ID
    }

    @Test
    public void testDeleteContact() {
        assertTrue(service.deleteContact("1"));
        assertFalse(service.deleteContact("1")); // already deleted
    }

    @Test
    public void testUpdateContactFields() {
        assertTrue(service.updateFirstName("1", "Alex"));
        assertEquals("Alex", service.getContact("1").getFirstName());

        assertTrue(service.updatePhone("1", "2223334444"));
        assertEquals("2223334444", service.getContact("1").getPhone());
    }

    @Test
    public void testUpdateNonexistentContact() {
        assertFalse(service.updateLastName("999", "Smith"));
    }
}
