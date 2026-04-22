
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {

    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskService();
    }

    @Test
    void testAddTask() {
        Task task = new Task("1", "Task One", "Description One");
        taskService.addTask(task);
        assertNotNull(taskService.getTask("1"));
    }

    @Test
    void testAddDuplicateTaskId() {
        Task task1 = new Task("1", "Task One", "Description One");
        Task task2 = new Task("1", "Task Two", "Description Two");
        taskService.addTask(task1);

        assertThrows(IllegalArgumentException.class, () ->
                taskService.addTask(task2));
    }

    @Test
    void testDeleteTask() {
        Task task = new Task("1", "Task One", "Description One");
        taskService.addTask(task);
        taskService.deleteTask("1");
        assertNull(taskService.getTask("1"));
    }

    @Test
    void testUpdateTaskName() {
        Task task = new Task("1", "Old Name", "Description");
        taskService.addTask(task);
        taskService.updateTaskName("1", "New Name");
        assertEquals("New Name", taskService.getTask("1").getName());
    }

    @Test
    void testUpdateTaskDescription() {
        Task task = new Task("1", "Name", "Old Description");
        taskService.addTask(task);
        taskService.updateTaskDescription("1", "New Description");
        assertEquals("New Description", taskService.getTask("1").getDescription());
    }

    @Test
    void testUpdateNonexistentTask() {
        assertThrows(IllegalArgumentException.class, () ->
                taskService.updateTaskName("999", "Name"));
    }
}
