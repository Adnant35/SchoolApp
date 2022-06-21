package tr.com.kolaysoft.school.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.kolaysoft.school.repository.StudentRepository;
import tr.com.kolaysoft.school.service.dto.StudentDTO;
import tr.com.kolaysoft.school.service.StudentService;
import tr.com.kolaysoft.school.web.rest.errors.BadRequestAlertException;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentResource {

    private final StudentService studentService;

    private final StudentRepository studentRepository;

    public StudentResource(StudentService studentService, StudentRepository studentRepository) {

        this.studentService = studentService;
        this.studentRepository = studentRepository;

    }

    @PostMapping("/stundents")
    public ResponseEntity<StudentDTO> createStudent(@Valid @RequestBody StudentDTO studentDTO) throws URISyntaxException {
        if (studentDTO.getStudent_id() == null) {
            throw new BadRequestAlertException("A new student cannot already have an ID");
        }

        StudentDTO result = studentService.save(studentDTO);
        return ResponseEntity.created(new URI("/api/students/" + result.getStudent_id())).body(result);

    }
    @PutMapping("/students")
    public ResponseEntity<StudentDTO> updateStudent(@Valid @RequestBody StudentDTO studentDTO) {
        if (studentDTO.getStudent_id()==null) {
                throw new BadRequestAlertException("invalid student id");
        }
        if (!studentRepository.existsById(studentDTO.getStudent_id())){
                throw  new BadRequestAlertException("Entity not found");
        }

        StudentDTO result= studentService.save(studentDTO);
        return ResponseEntity.ok().body(result);
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable Long id) {
        Optional<StudentDTO> studentDTO = studentService.findOne(id);
        return ResponseEntity.ok(studentDTO.orElse(null));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }


}


