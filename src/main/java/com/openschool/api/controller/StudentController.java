package com.openschool.api.controller;
import com.openschool.api.model.dtos.response.StudentResponseDTO;
import com.openschool.api.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping
    public ResponseEntity<Page<StudentResponseDTO>> getStudents(@PageableDefault(size = 10) Pageable pageable) {
        return studentService.getStudents(pageable);
    }
}
