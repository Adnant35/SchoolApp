package tr.com.kolaysoft.school.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.kolaysoft.school.repository.DepartmentRepository;
import tr.com.kolaysoft.school.service.DepartmentService;
import tr.com.kolaysoft.school.service.dto.DepartmentDTO;
import tr.com.kolaysoft.school.web.rest.errors.BadRequestAlertException;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DepartmentResource {

    private final DepartmentService departmentService;

    private final DepartmentRepository departmentRepository;

    public DepartmentResource(DepartmentService departmentService, DepartmentRepository departmentRepository) {
        this.departmentService = departmentService;
        this.departmentRepository = departmentRepository;
    }

    @PostMapping("/departments")
    public ResponseEntity<DepartmentDTO> createDepartment(@Valid @RequestBody DepartmentDTO departmentDTO) throws URISyntaxException {

        if(departmentDTO.getDepartment_id() == null){
            throw new BadRequestAlertException("A new department cannot already have an ID");
        }
    DepartmentDTO result= departmentService.save(departmentDTO);
        return ResponseEntity.created(new URI("/api/departments/"+ result.getDepartment_id())).body(result);
}

    @PutMapping("/departments")
    public  ResponseEntity<DepartmentDTO> updateDepartment(@Valid @RequestBody DepartmentDTO departmentDTO){
        if (departmentDTO.getDepartment_id() == null){
            throw new BadRequestAlertException("invalid department id");
        }
        if (!departmentRepository.existsById(departmentDTO.getDepartment_id())){
            throw new BadRequestAlertException("Entity not found");
        }
        DepartmentDTO result= departmentService.save(departmentDTO);
        return ResponseEntity.ok().body(result);
    }
    @GetMapping("/departments/{id}")
    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable Long id) {
        Optional<DepartmentDTO> departmentDTO = departmentService.findOne(id);
        return ResponseEntity.ok(departmentDTO.orElse(null));
    }
    @DeleteMapping("/departments/{id}")
    public ResponseEntity<Void> deleteDeparments(@PathVariable Long id){
        departmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

