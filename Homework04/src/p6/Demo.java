package p6;

import p5.GBag;

import java.util.Comparator;

public class Demo {
    public static void main(String[] args) {
        GBag<Student> students = new GBag<>(Student.class, 5);
        System.out.println("=== ORIGINAL ARRAY ===");
        students.insert(new Student("A", randomGpa()));
        students.insert(new Student("B", randomGpa()));
        students.insert(new Student("C", randomGpa()));
        students.insert(new Student("D", randomGpa()));
        students.insert(new Student("E", randomGpa()));
        students.insert(new Student("A", randomGpa()));
        students.display();

        // FIND
        System.out.println("FIND STUDENTS NAMED \"A\"");
        Student[] studentsNamedA = students.find(student -> student.getName().equals("A"));
        display(studentsNamedA);

        // DELETE
        System.out.println("DELETE STUDENTS WITH GPA < 1.0");
        Student[] toDelete = students.find(student -> student.getGpa() < 1.0);
        display(toDelete);
        for (Student student : toDelete) {
            students.remove(student);
        }

        // DISPLAY BY GPA
        System.out.println("STUDENTS DISPLAYED BY GPA ORDERING");
        students.displayBy(Comparator.comparingDouble(Student::getGpa));
    }

    private static double randomGpa() {
        return Math.random() * 4.0;
    }

    private static void display(Student... students) {
        for (int i = 0; i < students.length; i++) {
            System.out.printf("[%d]: %s%n", i, students[i]);
        }
    }
}
