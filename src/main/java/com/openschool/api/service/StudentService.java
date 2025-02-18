package com.openschool.api.service;

import com.openschool.api.model.dtos.request.StudentRequestDTO;
import com.openschool.api.model.dtos.response.StudentResponseDTO;
import com.openschool.api.model.entity.Student;
import com.openschool.api.model.repository.StudentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public ResponseEntity<Page<StudentResponseDTO>> getStudents(Pageable pageable) {
        return ResponseEntity.ok(studentRepository.findAll(pageable).map(StudentResponseDTO::new));
    }

    public ResponseEntity<StudentResponseDTO> getStudentById(Long id) {
        var student = studentRepository.getReferenceById(id);
        return ResponseEntity.ok(new StudentResponseDTO(student));
    }

    public ResponseEntity<StudentResponseDTO> createStudent(@Valid StudentRequestDTO studentData) {
        var student = new Student(studentData);
        studentRepository.save(student);
        return ResponseEntity.ok(new StudentResponseDTO(student));
    }
}
