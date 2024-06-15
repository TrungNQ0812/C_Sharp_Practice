
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class BOStudentTest {

    BOStudent bo;
    ArrayList<Student> listStudent;

    @Before
    public void setUp() {
        bo = new BOStudent();
        listStudent = new ArrayList<>();
        listStudent.add(new Student("S001", "Alice Johnson", "Spring 2024", "Math"));
        listStudent.add(new Student("S002", "Bob Smith", "Fall 2023", "Science"));
        listStudent.add(new Student("S003", "Charlie Brown", "Spring 2024", "History"));
        listStudent.add(new Student("S004", "David Wilson", "Fall 2023", "English"));
        listStudent.add(new Student("S005", "Eva Green", "Spring 2024", "Biology"));

        for (Student student : listStudent) {
            bo.addStudent(student);
        }
    }

    @Test
    public void testAddStudent1() {
        // Trường hợp bình thường
        Student newStudent = new Student("S006", "Frank Miller", "Fall 2024", "Math");
        bo.addStudent(newStudent);
        assertTrue(bo.findStudentById("S006").contains(newStudent));
    }
    @Test
    public void testAddStudent2() {
        // Trường hợp biên
        Student duplicateStudent = new Student("S001", "Alice Johnson", "Spring 2024", "Math");
        bo.addStudent(duplicateStudent);
        assertEquals(1, bo.findStudentById("S001").size()); // Chỉ có 1 sinh viên với ID S001
    }
    @Test
    public void testAddStudent3() {
        // Trường hợp bất thường
        Student invalidStudent = new Student("", "Alice Johnson", "Fall 2024", "Math");
        bo.addStudent(invalidStudent);
        assertFalse(bo.findStudentById("").contains(invalidStudent));
    }

    @Test
    public void testCheckValid1() {
        // Trường hợp bình thường
        Student newStudent = new Student("S006", "Frank Miller", "Fall 2024", "Math");
        assertTrue(bo.checkValid(newStudent));
    }
    @Test
    public void testCheckValid2() {
        // Trường hợp biên
        Student invalidStudent = new Student("S001", "Alice Johnson", "Spring 2024", "Math");
        assertTrue(bo.checkValid(invalidStudent));
    }
    @Test
    public void testCheckValid3() {
        // Trường hợp bất thường
        Student invalidStudent2 = new Student("", "Invalid Student", "Fall 2024", "Math");
        assertFalse(bo.checkValid(invalidStudent2));
    }

    @Test
    public void testFindStudentByName1() {
        // Trường hợp bình thường
        ArrayList<Student> foundStudents = bo.findStudentByName("Alice");
        assertEquals(1, foundStudents.size());
        assertEquals("Alice Johnson", foundStudents.get(0).getStudentName());
    }
    @Test
    public void testFindStudentByName2() {
        // Trường hợp biên
        ArrayList<Student> notFoundStudents = bo.findStudentByName("NonExistentName");
        assertTrue(notFoundStudents.isEmpty());
    }
    @Test
    public void testFindStudentByName3() {
        // Trường hợp bất thường
        ArrayList<Student> allStudents = bo.findStudentByName("");
        assertEquals(5, allStudents.size());
    }

    @Test
    public void testFindStudentById1() {
        // Trường hợp bình thường
        ArrayList<Student> foundStudents = bo.findStudentById("S001");
        assertEquals(1, foundStudents.size());
        assertEquals("S001", foundStudents.get(0).getId());

    }
    @Test
    public void testFindStudentById2() {
        // Trường hợp biên
        ArrayList<Student> notFoundStudents = bo.findStudentById("S999");
        assertTrue(notFoundStudents.isEmpty());
    }
    @Test
    public void testFindStudentById3() {
        // Trường hợp bất thường
        ArrayList<Student> emptyIdStudents = bo.findStudentById("");
        assertTrue(emptyIdStudents.isEmpty());
    }

    @Test
    public void testDisplayListStudent() {
        // This test checks if the displayListStudent method runs without errors
        // Manual verification needed for actual display output
        bo.displayListStudent();
    }

    @Test
    public void testIsEmptyList() {
        assertFalse(bo.isEmptyList());

        BOStudent emptyBO = new BOStudent();
        assertTrue(emptyBO.isEmptyList());
    }

    @Test
    public void testUpdateStudent() {
        Student student = bo.getStudentById("S001");
        bo.updateStudent(student, "S001", "Alice Johnson Updated", "Spring 2024", "Math");
        assertEquals("Alice Johnson Updated", student.getStudentName());
    }

    @Test
    public void testDeleteStudent() {
        Student student = bo.getStudentById("S001");
        bo.deleteStudent(student);
        assertTrue(bo.findStudentById("S001").isEmpty());
    }

    @Test
    public void testGetReportList() {
        ArrayList<Report> reportList = bo.getReportList();
        assertNotNull(reportList);
        assertEquals(5, reportList.size());
    }

    @Test
    public void testGetNumberStudent() {
        assertEquals(5, bo.getNumberStudent());
    }

    @Test
    public void testIsExistedId1() {
        assertTrue(bo.isExistedId("S001"));
    }
    @Test
    public void testIsExistedId2() {
        assertFalse(bo.isExistedId("S999"));
    }

    @Test
    public void testGetStudentById1() {
        Student student = bo.getStudentById("S001");
        assertNotNull(student);
    }
    @Test
    public void testGetStudentById2() {
        Student student = bo.getStudentById("S001");
        assertEquals("S001", student.getId());
    }

    @Test
    public void testSortStudentByNameAsc() {
        ArrayList<Student> studentList = bo.findStudentByName("");
        bo.sortStudentByNameAsc(studentList);
        assertEquals("Alice Johnson", studentList.get(0).getStudentName());
        assertEquals("Bob Smith", studentList.get(1).getStudentName());
    }

    @Test
    public void testIsDuplicateStudent() {
        Student duplicateStudent = new Student("S001", "Alice Johnson", "Spring 2024", "Math");
        assertTrue(bo.isDuplicateStudent(duplicateStudent));

        Student newStudent = new Student("S001", "Frank Miller", "Fall 2024", "Math");
        assertTrue(bo.isDuplicateStudent(newStudent));
    }
}
