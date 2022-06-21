package tr.com.kolaysoft.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.kolaysoft.school.domain.Student;
import tr.com.kolaysoft.school.repository.StudentRepository;
import tr.com.kolaysoft.school.service.dto.StudentDTO;
import tr.com.kolaysoft.school.service.mapper.StudentMapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;


    @Autowired
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository,StudentMapper studentMapper){

        this.studentRepository=studentRepository;
        this.studentMapper=studentMapper;

    }


    public StudentDTO save(StudentDTO studentDTO){

        Student student= studentMapper.toEntity(studentDTO);
        student =studentRepository.save(student);
        return studentMapper.toDto(student);
    }
    @Transactional(readOnly = true)
    public List<StudentDTO> findAll(){
        return studentRepository.findAll().stream().map(studentMapper::toDto).collect(Collectors.toCollection(LinkedList::new));

    }

    @Transactional(readOnly = true)
    public Optional<StudentDTO>findOne(Long id){return studentRepository.findById(id).map(studentMapper::toDto);}


    public void delete(Long id) { studentRepository.deleteById(id);}


}
