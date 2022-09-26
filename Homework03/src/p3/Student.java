package p3;

import java.time.LocalDate;
import java.util.StringJoiner;

public class Student {
    private String name;
    private String phone;
    private LocalDate regDate;

    public Student(String name, String phone, LocalDate regDate) {
        this.name = name;
        this.phone = phone;
        this.regDate = regDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("phone='" + phone + "'")
                .add("regDate=" + regDate)
                .toString();
    }
}
