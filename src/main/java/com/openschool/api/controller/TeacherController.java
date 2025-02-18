package com.openschool.api.controller;

import com.openschool.api.model.dtos.request.TeacherRequestDTO;
import com.openschool.api.model.dtos.response.TeacherResponseDTO;
import com.openschool.api.service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/{id}")
    public ResponseEntity<TeacherResponseDTO> getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @GetMapping
    public ResponseEntity<Page<TeacherResponseDTO>> getTeachers(@PageableDefault(size = 10) Pageable pageable) {
        return teacherService.getTeachers(pageable);
    }

    @PostMapping
    public ResponseEntity<TeacherResponseDTO> createTeacher(@Valid @RequestBody TeacherRequestDTO teacherRequestDTO) {
        return teacherService.createTeacher(teacherRequestDTO);
    }
}
