package tr.com.kolaysoft.school.service.dto;

import java.io.Serializable;
import java.util.Objects;

public class DepartmentDTO implements Serializable {

    private Long department_id;

    private  String name;

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentDTO that = (DepartmentDTO) o;
        return Objects.equals(department_id, that.department_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(department_id);
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "department_id=" + department_id +
                ", name='" + name + '\'' +
                '}';
    }
}
