package com.openschool.api.model.dtos.response;

import com.openschool.api.model.entity.Subject;
import io.swagger.v3.oas.annotations.media.Schema;

public record SubjectResponseDTO(
        @Schema(description = "id da disciplina", example = "1")
        Long id,

        @Schema(description = "nome da disciplina", example = "Matemática")
        String name
) {
    public SubjectResponseDTO(Subject subject) {
        this(subject.getId(), subject.getName());
    }
}
