package tr.com.kolaysoft.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.kolaysoft.school.domain.Department;
import tr.com.kolaysoft.school.repository.DepartmentRepository;
import tr.com.kolaysoft.school.service.dto.DepartmentDTO;
import tr.com.kolaysoft.school.service.mapper.DepartmentMapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    private final DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    public DepartmentDTO save (DepartmentDTO departmentDTO){

        Department department=departmentMapper.toEntity(departmentDTO);
        department=departmentRepository.save(department);
        return departmentMapper.toDto(department);

    }
    @Transactional(readOnly = true)
    public List<DepartmentDTO> findAll(){
        return departmentRepository.findAll().stream().map(departmentMapper::toDto).collect(Collectors.toCollection(LinkedList::new));

    }


    @Transactional(readOnly = true)
    public Optional<DepartmentDTO> findOne(Long id){return departmentRepository.findById(id).map(departmentMapper::toDto);}

    public void delete(Long id){ departmentRepository.deleteById(id);}
}
