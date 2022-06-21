package tr.com.kolaysoft.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.kolaysoft.school.domain.Department;

public interface DepartmentRepository  extends JpaRepository<Department, Long> {


}
