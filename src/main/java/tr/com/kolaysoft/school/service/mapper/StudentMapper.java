package tr.com.kolaysoft.school.service.mapper;


import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import tr.com.kolaysoft.school.domain.Student;
import tr.com.kolaysoft.school.service.dto.StudentDTO;

@Mapper(componentModel = "spring")
public interface StudentMapper extends  EntityMapper<StudentDTO, Student> { }
