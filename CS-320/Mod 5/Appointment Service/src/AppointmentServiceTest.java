
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {

    @Test
    void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment(
                "A1",
                new Date(System.currentTimeMillis() + 10_00_00),
                "Check-up"
        );

        service.addAppointment(appointment);
        assertNotNull(service.getAppointment("A1"));
    }

    @Test
    void testAddDuplicateAppointmentId() {
        AppointmentService service = new AppointmentService();
        Appointment appointment1 = new Appointment(
                "A1",
                new Date(System.currentTimeMillis() + 10_00_00),
                "Check-up"
        );
        Appointment appointment2 = new Appointment(
                "A1",
                new Date(System.currentTimeMillis() + 20_00_00),
                "Follow-up"
        );

        service.addAppointment(appointment1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appointment2);
        });
    }

    @Test
    void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment(
                "A2",
                new Date(System.currentTimeMillis() + 10_00_00),
                "Dentist"
        );

        service.addAppointment(appointment);
        service.deleteAppointment("A2");

        assertNull(service.getAppointment("A2"));
    }

    @Test
    void testDeleteNonExistentAppointment() {
        AppointmentService service = new AppointmentService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("A99");
        });
    }
}
