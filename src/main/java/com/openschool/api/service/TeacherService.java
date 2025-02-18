package com.openschool.api.service;

import com.openschool.api.model.dtos.response.TeacherResponseDTO;
import com.openschool.api.model.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public ResponseEntity<TeacherResponseDTO> getTeacherById(Long id) {
        var teacher = teacherRepository.getReferenceById(id);
        return ResponseEntity.ok(new TeacherResponseDTO(teacher));
    }

    public ResponseEntity<Page<TeacherResponseDTO>> getTeachers(Pageable pageable) {
        return ResponseEntity.ok(teacherRepository.findAll(pageable).map(TeacherResponseDTO::new));
    }
}
