import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class StudentDatabaseTest {

    @Mock
    StudentDatabase database;

    @Test
    public void testAddStudent(){
        Student student = new Student(1, "Alice", 22);
        database.addStudent(student);

        verify(database).addStudent(student);
        verifyNoMoreInteractions(database);
    }

    @Test
    public ArrayList<Student> createData(){
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Sebastian", 22));
        students.add(new Student(2, "Abraham", 22));
        students.add(new Student(3, "Miguel", 22));
        students.add(new Student(4, "Jose", 22));
        return students;
    }

    @Test
    public void testGetNumberOfStudents(){

        ArrayList<Student> data = createData();

        when(database.getAllStudents()).thenReturn(data);

        ArrayList<Student> resStudents = (ArrayList<Student>) database.getAllStudents();
        int sizeActual = resStudents.size();
        int sizeExpected = data.size();
        assertEquals(sizeExpected, sizeActual);

        verify(database).getAllStudents();
        verifyNoMoreInteractions(database);
    }

    @Test
    public void testGetStudentById() {
        ArrayList<Student> data = createData();
        int idToFind = 2;
        Student studentToFind = data.get(1); // Student with ID 2

        when(database.getStudentById(idToFind)).thenReturn(studentToFind);

        Student foundStudent = database.getStudentById(idToFind);

        assertEquals(studentToFind, foundStudent);

        verify(database).getStudentById(idToFind);
        verifyNoMoreInteractions(database);
    }
    @Test
    public void testUpdateStudent() {
        Student updatedStudent = new Student(2, "Updated Name", 25);

        database.updateStudent(updatedStudent);

        verify(database).updateStudent(updatedStudent);
        verifyNoMoreInteractions(database);
    }

    @Test
    public void testDeleteStudent() {
        int idToDelete = 3;

        database.deleteStudent(idToDelete);

        verify(database).deleteStudent(idToDelete);
        verifyNoMoreInteractions(database);
    }
}
