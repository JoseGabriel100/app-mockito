public class Main {
    public static void main(String[] args) {
        StudentDatabase studentDatabase = new StudentDatabase();

        // Add a student
        Student student1 = new Student(1, "Alice", 30);
        Student student2 = new Student(2, "Joe", 40);
        studentDatabase.addStudent(student1);
        studentDatabase.addStudent(student2);

        // Get all students
        System.out.println("All students: ");
        for (Student student : studentDatabase.getAllStudents()) {
            System.out.println(student);
        }

        // Update a student
        Student updatedStudent = new Student(1, "Alice Updated", 31);
        studentDatabase.updateStudent(updatedStudent);

        // Get a student by ID
        Student retrievedStudent = studentDatabase.getStudentById(1);
        System.out.println("Retrieved student by ID:");
        System.out.println(retrievedStudent);

        // Delete a student
        studentDatabase.deleteStudent(1);

        // Get all students after deletion
        System.out.println("All students after Deletion:");
        for (Student student : studentDatabase.getAllStudents()) {
            System.out.println(student);
        }
    }
}

