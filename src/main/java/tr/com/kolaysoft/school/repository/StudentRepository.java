package tr.com.kolaysoft.school.repository;
import org.springframework.data.jpa.repository.*;
import tr.com.kolaysoft.school.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
}
