package tr.com.kolaysoft.school.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class StudentDTO implements Serializable {

    private Long student_id;

    private String name;

    private Long department_id;

    private Instant createdDate;

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDTO that = (StudentDTO) o;
        return student_id == that.student_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(student_id);
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "student_id=" + student_id +
                ", name='" + name + '\'' +
                ", department_id=" + department_id +
                '}';
    }
}
