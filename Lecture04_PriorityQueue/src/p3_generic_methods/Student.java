package p3_generic_methods;

import java.util.StringJoiner;

public class Student implements Comparable<Student> {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    /**
     * we compare by name.
     * @param o the object to be compared.
     * @return the result of the name comparison.
     */
    @Override
    public int compareTo(Student o) {
        //return this.name.compareTo(o.getName()); // <- compare by name (ascending)
        return -this.name.compareTo(o.getName()); // <- compare by name (descending)
        //return Double.compare(this.gpa, o.getGpa()); // <- compare by gpa
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("gpa=" + gpa)
                .toString();
    }
}
