import com.google.gson.Gson;                   // Importación de la biblioteca Gson para la serialización y deserialización de objetos JSON.
import com.google.gson.reflect.TypeToken;      // Importación de TypeToken para obtener información de tipos de objetos genéricos.
import java.io.*;                              // Importación de las clases relacionadas con operaciones de entrada/salida.
import java.util.ArrayList;                    // Importación de ArrayList para gestionar una lista dinámica de objetos.
import java.util.List;                         // Importación de List para trabajar con listas de objetos genéricos.


public class StudentDatabase {
    private final List<Student> students;    // Lista de estudiantes en la base de datos
    private final String filename = "src/main/java/students.json";   // Nombre del archivo de almacenamiento
    private final Gson gson = new Gson();    // Instancia de Gson para la serialización/deserialización JSON

    // Constructor de la clase StudentDatabase
    public StudentDatabase() {
        this.students = loadStudent();
    }

    // Método privado para cargar la lista de estudiantes desde un archivo JSON
    private List<Student> loadStudent() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return gson.fromJson(reader, new TypeToken<List<Student>>(){}.getType());
        } catch (FileNotFoundException e) {
            // Si el archivo no se encuentra, devuelve una lista vacía
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Método privado para guardar la lista de estudiantes en un archivo JSON
    private void saveStudent() {
        try (Writer writer = new FileWriter(filename)) {
            gson.toJson(students, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todos los estudiantes en la base de datos
    public List<Student> getAllStudents() {
        return students;
    }

    // Método para obtener un estudiante por su ID
    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null; // Devuelve null si no se encuentra un estudiante con el ID especificado
    }

    // Método para agregar un estudiante a la base de datos
    public void addStudent(Student student) {
        students.add(student);
        saveStudent(); // Guarda la lista de estudiantes actualizada
    }

    // Método para actualizar un estudiante en la base de datos
    public void updateStudent(Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getId() == updatedStudent.getId()) {
                students.set(i, updatedStudent);
                saveStudent(); // Guarda la lista de estudiantes actualizada
                return;
            }
        }
    }

    // Método para eliminar un estudiante de la base de datos por su ID
    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
        saveStudent(); // Guarda la lista de estudiantes actualizada después de la eliminación
    }
}
