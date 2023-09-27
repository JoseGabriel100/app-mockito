public class Student {
    private int id;         // ID del estudiante
    private String name;    // Nombre del estudiante
    private int age;        // Edad del estudiante

    // Constructor de la clase Student
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Métodos para obtener y establecer el ID del estudiante
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Métodos para obtener y establecer el nombre del estudiante
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Métodos para obtener y establecer la edad del estudiante
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Método toString para representar el objeto Student como una cadena
    public String toString(){
        return "Student(id: "+id+", name: "+name+", age: "+age+")";
    }
}
