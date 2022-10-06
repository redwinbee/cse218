package p2_generic_arrays;

import p2_generic_arrays.util.StudentGenerator;

public class Demo {
    private static final int NUM_STUDENTS = 10;

    public static void main(String[] args) {
        Bag<Student> bag = new Bag<>(Student.class, NUM_STUDENTS);
        bag.insertAll(StudentGenerator.genStudents(NUM_STUDENTS));
//        Student[] randomStudents = StudentGenerator.genStudents(NUM_STUDENTS);
//        for (Student student : randomStudents) {
//            bag.insert(student);
//        }

        bag.display();

        System.out.println("Greater than 2.0 GPA");
        Student[] greaterThan20Gpa = bag.search((student) -> student.getGpa() > 2.0);
        display(greaterThan20Gpa);
    }

    private static void display(Student... students) {
        for (int i = 0; i < students.length; i++) {
            System.out.printf("[%d]: %s%n", i, students[i]);
        }
    }
}
