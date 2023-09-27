public class Main {
    public static void main(String[] args) {
        StudentDatabase studentDatabase = new StudentDatabase();

        // Agregar un estudiante
        Student student1 = new Student(1, "Alice", 30);
        Student student2 = new Student(2, "Joe", 40);
        studentDatabase.addStudent(student1);
        studentDatabase.addStudent(student2);

        // Obtener todos los estudiantes
        System.out.println("Todos los estudiantes: ");
        for (Student student : studentDatabase.getAllStudents()) {
            System.out.println(student);
        }

        // Actualizar un estudiante
        Student updatedStudent = new Student(1, "Alice Actualizada", 31);
        studentDatabase.updateStudent(updatedStudent);

        // Obtener un estudiante por ID
        Student retrievedStudent = studentDatabase.getStudentById(1);
        System.out.println("Estudiante recuperado por ID:");
        System.out.println(retrievedStudent);

        // Eliminar un estudiante
        studentDatabase.deleteStudent(1);

        // Obtener todos los estudiantes después de la eliminación
        System.out.println("Todos los estudiantes después de la eliminación:");
        for (Student student : studentDatabase.getAllStudents()) {
            System.out.println(student);
        }
    }
}
