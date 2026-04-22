

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    void testValidTaskCreation() {
        Task task = new Task("12345", "Test Task", "Test Description");
        assertEquals("12345", task.getTaskId());
        assertEquals("Test Task", task.getName());
        assertEquals("Test Description", task.getDescription());
    }

    @Test
    void testInvalidTaskId() {
        assertThrows(IllegalArgumentException.class, () ->
                new Task(null, "Name", "Description"));
        assertThrows(IllegalArgumentException.class, () ->
                new Task("12345678901", "Name", "Description"));
    }

    @Test
    void testInvalidName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Task("123", null, "Description"));
        assertThrows(IllegalArgumentException.class, () ->
                new Task("123", "This name is definitely too long", "Description"));
    }

    @Test
    void testInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () ->
                new Task("123", "Name", null));
        assertThrows(IllegalArgumentException.class, () ->
                new Task("123", "Name",
                        "This description is far too long and exceeds fifty characters total."));
    }

    @Test
    void testUpdateName() {
        Task task = new Task("123", "Old Name", "Description");
        task.setName("New Name");
        assertEquals("New Name", task.getName());
    }

    @Test
    void testUpdateDescription() {
        Task task = new Task("123", "Name", "Old Description");
        task.setDescription("New Description");
        assertEquals("New Description", task.getDescription());
    }
}
