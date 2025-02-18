package com.openschool.api.service;

import com.openschool.api.model.Address;
import com.openschool.api.model.dtos.request.StudentRequestDTO;
import com.openschool.api.model.dtos.response.StudentResponseDTO;
import com.openschool.api.model.entity.Student;
import com.openschool.api.model.entity.Subject;
import com.openschool.api.model.repository.StudentRepository;
import com.openschool.api.model.repository.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final SubjectRepository subjectRepository;

    public ResponseEntity<StudentResponseDTO> getStudentById(Long id) {
        var student = studentRepository.getReferenceById(id);
        return ResponseEntity.ok(new StudentResponseDTO(student));
    }

    public ResponseEntity<Page<StudentResponseDTO>> getStudents(Pageable pageable) {
        return ResponseEntity.ok(studentRepository.findAll(pageable).map(StudentResponseDTO::new));
    }

    public ResponseEntity<StudentResponseDTO> createStudent(@Valid StudentRequestDTO studentData) {
        List<Subject> subjects = studentData.subjectIds().stream()
                        .map(id -> subjectRepository.findById(id)
                                .orElseThrow(() -> new EntityNotFoundException("Subject not found with id " + id)))
                        .toList();

        var student = new Student(studentData, subjects);
        studentRepository.save(student);
        return ResponseEntity.ok(new StudentResponseDTO(student));
    }

    public ResponseEntity<StudentResponseDTO> updateStudent(Long id, @Valid StudentRequestDTO studentData) {
        var student = studentRepository.getReferenceById(id);
        List<Subject> subjects = new ArrayList<>(studentData.subjectIds().stream()
                .map(subjectId -> subjectRepository.findById(subjectId)
                        .orElseThrow(() -> new EntityNotFoundException("Subject not found with id " + subjectId)))
                .toList());

        student.setName(studentData.name());
        student.setBirthdate(studentData.birthdate());
        student.setEmail(studentData.email());
        student.setAddress(new Address(studentData.address()));

        if (!subjects.isEmpty()) {
            student.setSubjects(subjects);
        } else {
            throw new IllegalArgumentException("Student must have at least one subject");
        }

        studentRepository.save(student);

        return ResponseEntity.ok(new StudentResponseDTO(student));
    }

    public ResponseEntity<Void> deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        studentRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
