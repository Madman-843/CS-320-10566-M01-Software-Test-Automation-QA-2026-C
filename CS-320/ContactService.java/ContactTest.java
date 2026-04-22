
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact c = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("12345", c.getContactID());
        assertEquals("John", c.getFirstName());
    }

    @Test
    public void testInvalidID() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "123", "123 Main St");
        });
    }

    @Test
    public void testSetters() {
        Contact c = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        c.setFirstName("Jane");
        assertEquals("Jane", c.getFirstName());
    }
}
