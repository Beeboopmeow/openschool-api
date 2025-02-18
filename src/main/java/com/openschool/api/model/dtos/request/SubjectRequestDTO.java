package com.openschool.api.model.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record SubjectRequestDTO(
        @NotBlank (message = "Nome da disciplina é obrigatório")
        @Schema(description = "Nome da disciplina", example = "Matemática")
        String name
) {
}
