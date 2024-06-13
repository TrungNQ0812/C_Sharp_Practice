/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0071;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author trung
 */
public class TaskManagementTest {
    private TaskManagement taskManagement;

    @Before
    public void setUp() {
        taskManagement = new TaskManagement();
    }
    
    public TaskManagementTest() {
    }

    @Test
    public void testIsEmptyList() {
         assertTrue(taskManagement.isEmptyList());
        
        taskManagement.addTask("1", "Task1", "2023-06-13", 9.0, 11.0, "Alice", "Bob");
        assertFalse(taskManagement.isEmptyList());
    }

    @Test
    public void testGetTaskList() {
        assertEquals(0, taskManagement.getTaskList().size());

        taskManagement.addTask("1", "Task1", "2023-06-13", 9.0, 11.0, "Alice", "Bob");
        assertEquals(1, taskManagement.getTaskList().size());
    }

    @Test
    public void testIncreaseLastId() {
        taskManagement.addTask("1", "Task1", "2023-06-13", 9.0, 11.0, "Alice", "Bob");
        taskManagement.addTask("1", "Task2", "2023-06-14", 10.0, 12.0, "Charlie", "Dave");

        assertEquals(3, taskManagement.increaseLastId());
    }

    @Test
    public void testAddTask() {
         int id1 = taskManagement.addTask("1", "Task1", "2023-06-13", 9.0, 11.0, "Alice", "Bob");
        assertEquals(1, id1);

        int id2 = taskManagement.addTask("1", "Task1", "2023-06-13", 9.0, 11.0, "Alice", "Bob");
        assertEquals(-1, id2);  // Duplicate task

        int id3 = taskManagement.addTask("1", "Task2", "2023-06-14", 10.0, 12.0, "Charlie", "Dave");
        assertEquals(2, id3);
    }

    @Test
    public void testCheckTime() {
        assertTrue(taskManagement.checkTime(9.0, 11.0));
        assertFalse(taskManagement.checkTime(11.0, 9.0));
    }

    @Test
    public void testCheckAssigneeReviewer() {
        assertTrue(taskManagement.checkAssigneeReviewer("Alice", "Alice"));
        assertFalse(taskManagement.checkAssigneeReviewer("Alice", "Bob"));
    }

    @Test
    public void testFindById() {
        taskManagement.addTask("1", "Task1", "2023-06-13", 9.0, 11.0, "Alice", "Bob");
        Task task = taskManagement.findById(1);
        assertNotNull(task);
        assertEquals("Task1", task.getRequirementName());

        Task notFoundTask = taskManagement.findById(999);
        assertNull(notFoundTask);
    }

    @Test
    public void testRemoveTask() {
        taskManagement.addTask("1", "Task1", "2023-06-13", 9.0, 11.0, "Alice", "Bob");
        Task task = taskManagement.findById(1);
        taskManagement.removeTask(task);
        assertNull(taskManagement.findById(1));
    }

    @Test
    public void testCheckDuplicateTask() {
        Task task1 = new Task(1, "1", "Task1", "2023-06-13", 9.0, 11.0, "Alice", "Bob");
        taskManagement.addTask("1", "Task1", "2023-06-13", 9.0, 11.0, "Alice", "Bob");

        Task duplicateTask = new Task(2, "1", "Task1", "2023-06-13", 9.0, 11.0, "Alice", "Bob");
        assertTrue(taskManagement.checkDuplicateTask(duplicateTask));

        Task uniqueTask = new Task(3, "2", "Task2", "2023-06-14", 10.0, 12.0, "Charlie", "Dave");
        assertFalse(taskManagement.checkDuplicateTask(uniqueTask));
    }
    
}
