package p2_generic_arrays.util;

import p2_generic_arrays.Student;

public final class StudentGenerator {
    private StudentGenerator() {}

    public static Student[] genStudents(int numStudents) {
        Student[] out = new Student[numStudents];
        for (int i = 0; i < out.length; i++) {
            out[i] = randomStudent();
        }

        return out;
    }

    public static Student randomStudent() {
        return new Student(randomName(), Math.random() * 4.0);
    }

    private static String randomName() {
        StringBuilder sb = new StringBuilder();
        sb.append((char) ((Math.random() * 26) + 'A'));
        for (int i = 0; i < 9; i++) {
            sb.append((char) ((Math.random() * 26) + 'a'));
        }

        return sb.toString();
    }
}
