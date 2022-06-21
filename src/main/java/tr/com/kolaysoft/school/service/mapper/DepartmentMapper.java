package tr.com.kolaysoft.school.service.mapper;

import org.mapstruct.Mapper;
import tr.com.kolaysoft.school.domain.Department;
import tr.com.kolaysoft.school.service.dto.DepartmentDTO;

@Mapper(componentModel= "spring")
public interface DepartmentMapper extends EntityMapper<DepartmentDTO, Department> {
}
