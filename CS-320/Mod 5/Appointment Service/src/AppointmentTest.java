
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.Test;

class AppointmentTest {

    @Test
    void testValidAppointmentCreation() {
        Date futureDate = new Date(System.currentTimeMillis() + 10_00_00);
        Appointment appointment = new Appointment("A123", futureDate, "Doctor visit");

        assertEquals("A123", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Doctor visit", appointment.getDescription());
    }

    @Test
    void testInvalidAppointmentIdTooLong() {
        Date futureDate = new Date(System.currentTimeMillis() + 10_00_00);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Description");
        });
    }

    @Test
    void testAppointmentDateInPast() {
        Date pastDate = new Date(System.currentTimeMillis() - 10_00_00);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A1", pastDate, "Past appointment");
        });
    }

    @Test
    void testNullDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 10_00_00);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A1", futureDate, null);
        });
    }
}
