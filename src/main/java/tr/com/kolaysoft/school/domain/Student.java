package tr.com.kolaysoft.school.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "student")
public class Student implements Serializable {


    @Id
    @Column(name="Student_id")
    public Long student_id;

    @NotNull
    @Column(name="name")
    private String name;

    @OneToOne
    @NotNull
    private Department department;

    @NotNull
    @Column(name="department_id")
    private Long department_id;

    public Student student_id(Long student_id) {
        this.setStudent_id(student_id);
        return this;
    }


    public long getStudent_id() {
        return this.student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public Student name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student department_id(Long department_id) {
        this.setDepartment_id(department_id);
        return this;
    }

    public long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return student_id == student.student_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(student_id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", name='" + name + '\'' +
                ", department_id=" + department_id +
                '}';
    }
}
