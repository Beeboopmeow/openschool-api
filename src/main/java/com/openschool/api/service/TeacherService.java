package com.openschool.api.service;

import com.openschool.api.model.Address;
import com.openschool.api.model.dtos.request.TeacherRequestDTO;
import com.openschool.api.model.dtos.response.TeacherResponseDTO;
import com.openschool.api.model.entity.Teacher;
import com.openschool.api.model.repository.SubjectRepository;
import com.openschool.api.model.repository.TeacherRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    private final SubjectRepository subjectRepository;

    public ResponseEntity<TeacherResponseDTO> getTeacherById(Long id) {
        var teacher = teacherRepository.getReferenceById(id);
        return ResponseEntity.ok(new TeacherResponseDTO(teacher));
    }

    public ResponseEntity<Page<TeacherResponseDTO>> getTeachers(Pageable pageable) {
        return ResponseEntity.ok(teacherRepository.findAll(pageable).map(TeacherResponseDTO::new));
    }

    public ResponseEntity<TeacherResponseDTO> createTeacher(@Valid TeacherRequestDTO teacherData) {
        var subject =  subjectRepository.findById(teacherData.subjectId())
                .orElseThrow(() -> new IllegalArgumentException("Subject not found with id " + teacherData.subjectId()));

        var teacher = new Teacher(teacherData, subject);
        teacherRepository.save(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(new TeacherResponseDTO(teacher));
    }

    public ResponseEntity<TeacherResponseDTO> updateTeacher(Long id, @Valid TeacherRequestDTO teacherData) {
        var teacher = teacherRepository.getReferenceById(id);

        teacher.setName(teacherData.name());
        teacher.setEmail(teacherData.email());
        teacher.setAddress(new Address(teacherData.address()));
        teacher.setCpf(teacherData.cpf());
        teacher.setSubject(subjectRepository.findById(teacherData.subjectId())
                .orElseThrow(() -> new IllegalArgumentException("Subject not found with id " + teacherData.subjectId())));

        teacherRepository.save(teacher);

        return ResponseEntity.ok(new TeacherResponseDTO(teacher));
    }

    public ResponseEntity<Void> deleteTeacher(Long id) {
        if (!teacherRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        teacherRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
