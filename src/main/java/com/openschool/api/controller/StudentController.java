package com.openschool.api.controller;
import com.openschool.api.controller.swagger.StudentControllerDoc;
import com.openschool.api.model.dtos.request.StudentRequestDTO;
import com.openschool.api.model.dtos.response.StudentResponseDTO;
import com.openschool.api.service.StudentService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController implements StudentControllerDoc {

    private final StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping
    public ResponseEntity<Page<StudentResponseDTO>> getStudents(@PageableDefault(size = 10) Pageable pageable) {
        return studentService.getStudents(pageable);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<StudentResponseDTO> createStudent(@Valid @RequestBody StudentRequestDTO studentRequestDTO) {
        return studentService.createStudent(studentRequestDTO);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<StudentResponseDTO> updateStudent(@PathVariable Long id, @Valid @RequestBody StudentRequestDTO studentRequestDTO) {
        return studentService.updateStudent(id, studentRequestDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }
}
