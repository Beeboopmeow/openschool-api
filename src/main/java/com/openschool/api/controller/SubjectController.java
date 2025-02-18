package com.openschool.api.controller;

import com.openschool.api.model.dtos.request.SubjectRequestDTO;
import com.openschool.api.model.dtos.response.SubjectResponseDTO;
import com.openschool.api.service.SubjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping("/{id}")
    public ResponseEntity<SubjectResponseDTO> getSubjectById(@PathVariable Long id) {
        return subjectService.getSubjectById(id);
    }

    @GetMapping
    public ResponseEntity<Page<SubjectResponseDTO>> getSubjects(@PageableDefault(size = 10) Pageable pageable) {
        return subjectService.getSubjects(pageable);
    }

    @PostMapping
    public ResponseEntity<SubjectResponseDTO> createSubject(@Valid @RequestBody SubjectRequestDTO subjectRequestDTO) {
        return subjectService.createSubject(subjectRequestDTO);
    }
}
