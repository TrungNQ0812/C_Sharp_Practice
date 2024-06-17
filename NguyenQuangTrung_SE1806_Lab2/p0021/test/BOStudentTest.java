
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
        listStudent.add(new Student("S002", "Bob Smith", "Fall 2023", "Science"));
        listStudent.add(new Student("S003", "Charlie Brown", "Spring 2024", "History"));
        listStudent.add(new Student("S004", "David Wilson", "Fall 2023", "English"));
        listStudent.add(new Student("S005", "Eva Green", "Spring 2024", "Biology"));
        listStudent.add(new Student("S001", "Alice Johnson", "Spring 2024", "Math"));

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
        
    }

   
    @Test
    public void testIsEmptyList() {
        assertFalse(bo.isEmptyList());

        BOStudent emptyBO = new BOStudent();
        assertFalse(emptyBO.isEmptyList());
    }

    @Test
    public void testUpdateStudent1() {
        Student student = bo.getStudentById("S001");
        bo.updateStudent(student, "S001", "Alice Johnson Updated", "Spring 2024", "Math");
        assertEquals("Alice Johnson Updated", student.getStudentName());
    }
    @Test
    public void testUpdateStudent2() {
        Student student = bo.getStudentById("S006");
        bo.updateStudent(student, "S006", "Frank Miller Updated", "Spring 2024", "Math");
        assertEquals("Alice Johnson Updated", student.getStudentName());
    }
    @Test
    public void testUpdateStudent3() {
        Student student = bo.getStudentById("");
        bo.updateStudent(student, "", "Not Exist Student", "Spring 2024", "Math");
        assertEquals("Not Exist Student", student.getStudentName());
    }

    @Test
    public void testDeleteStudent1() {
        Student student = bo.getStudentById("S001");
        assertFalse(bo.findStudentById("S001").isEmpty());
        bo.deleteStudent(student);
        assertTrue(bo.findStudentById("S001").isEmpty());
    }
    @Test
    public void testDeleteStudent2() {
        Student student = bo.getStudentById("S006");
        assertFalse(bo.findStudentById("S006").isEmpty());
        bo.deleteStudent(student);
        assertTrue(bo.findStudentById("S006").isEmpty());
    }
    @Test
    public void testDeleteStudent3() {
        Student student = bo.getStudentById("");
        assertFalse(bo.findStudentById("").isEmpty());
        bo.deleteStudent(student);
        assertTrue(bo.findStudentById("").isEmpty());
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
        assertTrue(bo.isExistedId("S006"));
    }
    @Test
    public void testIsExistedId3() {
        assertFalse(bo.isExistedId(""));
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
    public void testGetStudentById3() {
        Student student = bo.getStudentById("");
        assertEquals("", student.getId());
    }

    @Test
    public void testSortStudentByNameAsc1() {
        ArrayList<Student> studentList = bo.findStudentByName("");
        bo.sortStudentByNameAsc(studentList);
        assertEquals("Alice Johnson", studentList.get(0).getStudentName());
        assertEquals("Bob Smith", studentList.get(1).getStudentName());
    }
    @Test
    public void testSortStudentByNameAsc2() {
        ArrayList<Student> studentList = bo.findStudentByName("");
        bo.sortStudentByNameAsc(studentList);
        assertEquals("Alice Johnson", studentList.get(1).getStudentName());
        assertEquals("Bob Smith", studentList.get(0).getStudentName());
    }

    @Test
    public void testIsDuplicateStudent1() {
        Student duplicateStudent = new Student("S001", "Alice Johnson", "Spring 2024", "Math");
        assertTrue(bo.isDuplicateStudent(duplicateStudent));

        Student newStudent = new Student("S001", "Frank Miller", "Fall 2024", "Math");
        assertTrue(bo.isDuplicateStudent(newStudent));
    }
    @Test
    public void testIsDuplicateStudent2() {
        Student duplicateStudent = new Student("S001", "Alice Johnson", "Spring 2024", "Math");
        assertTrue(bo.isDuplicateStudent(duplicateStudent));

        Student newStudent = new Student("S001", "Alice Johnson", "Spring 2024", "Math");
        assertTrue(bo.isDuplicateStudent(newStudent));
    }
    @Test
    public void testIsDuplicateStudent3() {
        Student duplicateStudent = new Student("S001", "Alice Johnson", "Spring 2024", "Math");
        assertTrue(bo.isDuplicateStudent(duplicateStudent));

        Student newStudent = new Student("S006", "Frank Miller", "Fall 2024", "Math");
        assertTrue(bo.isDuplicateStudent(newStudent));
    }
}
