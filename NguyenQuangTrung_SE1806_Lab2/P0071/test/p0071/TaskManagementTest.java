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
    public void testIsEmptyList1() {
        assertTrue(taskManagement.isEmptyList());
    }

    @Test
    public void testIsEmptyList2() {
        taskManagement.addTask("1", "Task1", "2023-06-13", 9.0, 11.0, "Alice", "Bob");
        assertFalse(taskManagement.isEmptyList());
    }

    @Test
    public void testGetTaskList1() {
        assertEquals(0, taskManagement.getTaskList().size());
    }

    @Test
    public void testGetTaskList2() {
        taskManagement.addTask("1", "Task1", "2023-06-13", 9.0, 11.0, "Alice", "Bob");
        taskManagement.addTask("2", "Task2", "2023-06-14", 10.0, 12.0, "Charlie", "Dave");
        assertEquals(2, taskManagement.getTaskList().size());
    }

    @Test
    public void testIncreaseLastId1() {
        taskManagement.addTask("1", "Task1", "2023-06-13", 9.0, 11.0, "Alice", "Bob");
        taskManagement.addTask("2", "Task2", "2023-06-14", 10.0, 12.0, "Charlie", "Dave");
        taskManagement.addTask("3", "Task3", "2023-06-14", 11.0, 15.0, "Linda", "Paul");
        assertEquals(3, taskManagement.increaseLastId());
    }

    @Test
    public void testIncreaseLastId2() {
        taskManagement.addTask("1", "Task1", "2023-06-13", 9.0, 11.0, "Alice", "Bob");
        taskManagement.addTask("2", "Task2", "2023-06-14", 10.0, 12.0, "Charlie", "Dave");
        taskManagement.addTask("3", "Task3", "2023-06-14", 11.0, 15.0, "Linda", "Paul");

        assertEquals(4, taskManagement.increaseLastId());
    }

    @Test
    public void testAddTask1() {
        int id1 = taskManagement.addTask("1", "Task1", "2023-06-13", 9.0, 11.0, "Alice", "Bob");
        assertEquals(1, id1);
        int id2 = taskManagement.addTask("1", "Task1", "2023-06-13", 9.0, 11.0, "Alice", "Bob");
        assertEquals(-1, id2);  // Duplicate task
    }

    @Test
    public void testAddTask2() {
        int id3 = taskManagement.addTask("1", "Task2", "2023-06-14", 10.0, 12.0, "Charlie", "Dave");
        assertEquals(2, id3);
    }

    @Test
    public void testCheckTime1() {
        assertTrue(taskManagement.checkTime(9.0, 11.0));
    }
    @Test
    public void testCheckTime2() {
        assertFalse(taskManagement.checkTime(11.0, 9.0));
    }

    @Test
    public void testCheckAssigneeReviewer1() {
        assertTrue(taskManagement.checkAssigneeReviewer("Alice", "Alice"));
    }
    @Test
    public void testCheckAssigneeReviewer2() {
        assertFalse(taskManagement.checkAssigneeReviewer("Alice", "Bob"));
    }

    @Test
    public void testFindById1() {
        taskManagement.addTask("1", "Task1", "2023-06-13", 9.0, 11.0, "Alice", "Bob");
        Task task = taskManagement.findById(1);
        assertNotNull(task);
        assertEquals("Task1", task.getRequirementName());

    }
    @Test
    public void testFindById2() {
        taskManagement.addTask("1", "Task1", "2023-06-13", 9.0, 11.0, "Alice", "Bob");
        Task task = taskManagement.findById(1);
 
        Task notFoundTask = taskManagement.findById(999);
        assertNull(notFoundTask);
    }

    @Test
    public void testRemoveTask1() {
        taskManagement.addTask("1", "Task1", "2023-06-13", 9.0, 11.0, "Alice", "Bob");
        assertNotNull(taskManagement.findById(1));
        Task task = taskManagement.findById(1);
        taskManagement.removeTask(task);
        assertNull(taskManagement.findById(1));
    }
    @Test
    public void testRemoveTask2() {
        taskManagement.addTask("1", "Task1", "2023-06-13", 9.0, 11.0, "Alice", "Bob");
        assertNull(taskManagement.findById(999));
        Task task = taskManagement.findById(999);
        taskManagement.removeTask(task);
        assertNull(taskManagement.findById(999));
    }

    @Test
    public void testCheckDuplicateTask1() {
        taskManagement.addTask("1", "Task1", "2023-06-13", 9.0, 11.0, "Alice", "Bob");

        Task duplicateTask = new Task(2, "1", "Task1", "2023-06-13", 9.0, 11.0, "Alice", "Bob");
        assertTrue(taskManagement.checkDuplicateTask(duplicateTask));
    }
    
    @Test
    public void testCheckDuplicateTask2() {
        taskManagement.addTask("1", "Task1", "2023-06-13", 9.0, 11.0, "Alice", "Bob");

        Task uniqueTask = new Task(3, "2", "Task2", "2023-06-14", 10.0, 12.0, "Charlie", "Dave");
        assertFalse(taskManagement.checkDuplicateTask(uniqueTask));
    }

}
