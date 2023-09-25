import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDatabase {
    private final List<Student> students;
    private final String filename = "src/main/java/students.json";
    private final Gson gson = new Gson();

    public StudentDatabase() {
        this.students = loadStudent();
    }

//    https://stackoverflow.com/questions/43117731/what-is-type-typetoken
    private List<Student> loadStudent() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return gson.fromJson(reader, new TypeToken<List<Student>>(){}.getType());
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void saveStudent() {
        try (Writer writer = new FileWriter(filename)) {
            gson.toJson(students, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void addStudent(Student student) {
        students.add(student);
        saveStudent();
    }

    public void updateStudent(Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getId() == updatedStudent.getId()) {
                students.set(i, updatedStudent);
                saveStudent();
                return;
            }
        }
    }

    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
        saveStudent();
    }

}
