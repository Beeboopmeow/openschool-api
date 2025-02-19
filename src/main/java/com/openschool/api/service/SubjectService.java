package com.openschool.api.service;

import com.openschool.api.model.dtos.request.SubjectRequestDTO;
import com.openschool.api.model.dtos.response.SubjectResponseDTO;
import com.openschool.api.model.entity.Subject;
import com.openschool.api.model.repository.SubjectRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public ResponseEntity<SubjectResponseDTO> getSubjectById(Long id) {
        var subject = subjectRepository.getReferenceById(id);
        return ResponseEntity.ok(new SubjectResponseDTO(subject));
    }

    public ResponseEntity<Page<SubjectResponseDTO>> getSubjects(Pageable pageable) {
        return ResponseEntity.ok(subjectRepository.findAll(pageable).map(SubjectResponseDTO::new));
    }

    public ResponseEntity<SubjectResponseDTO> createSubject(@Valid SubjectRequestDTO subjectData) {
        var subject = new Subject(subjectData);
        subjectRepository.save(subject);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SubjectResponseDTO(subject));
    }

    public ResponseEntity<SubjectResponseDTO> updateSubject(Long id, @Valid SubjectRequestDTO subjectData) {
        var subject = subjectRepository.getReferenceById(id);

        subject.setName(subjectData.name());

        subjectRepository.save(subject);
        return ResponseEntity.ok(new SubjectResponseDTO(subject));
    }

    public ResponseEntity<Void> deleteSubject(Long id) {
        if (!subjectRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        subjectRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
