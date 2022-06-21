package tr.com.kolaysoft.school.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="department")
public class Department  implements Serializable {

    @Id
    @Column(name="department_id")
    public Long department_id;

    @NotNull
    @Column(name="name")
    private String name;

    public Long getDepartment_id() {
        return department_id;
    }

    public Department department_id(Long department_id) {
        this.setDepartment_id(department_id);
        return this;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    public String getName() {
        return name;
    }

    public Department name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return department_id.equals(that.department_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(department_id);
    }

    @Override
    public String toString() {
        return "Department{" +
                "department_id=" + department_id +
                ", name='" + name + '\'' +
                '}';
    }
}
