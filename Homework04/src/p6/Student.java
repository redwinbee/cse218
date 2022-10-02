package p6;

import java.util.StringJoiner;

public class Student implements Comparable<Student> {
    private static int idCounter;
    private String name;
    private String id;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.id = String.valueOf(idCounter++);
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("id='" + id + "'")
                .add("gpa=" + String.format("%.2f", gpa))
                .toString();
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(this.gpa, o.getGpa());
    }
}
