package com.openschool.api.model.dtos.request;

import com.openschool.api.model.Address;
import com.openschool.api.model.entity.Teacher;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record TeacherRequestDTO(
        @NotBlank(message = "Nome do professor é obrigatório")
        @Size(max=100, message = "Nome do professor deve ter no máximo 100 caracteres")
        @Schema(description = "Nome do professor", example = "Fernando")
        String name,

        @NotBlank(message = "Email do professor é obrigatório")
        @Schema(description = "Email do professor", example = "professor@email.com")
        String email,

        @NotNull(message = "Endereço do professor é obrigatório")
        @Valid
        AddressRequestDTO address,

        @NotBlank(message = "CPF do professor é obrigatório")
        @Pattern(regexp = "\\d{11}", message = "CPF inválido")
        @Schema(description = "CPF do professor", example = "12345678900")
        String cpf,

        @NotNull(message = "Id da disciplina é obrigatório")
        @Schema(description = "Id da disciplina lecionada pelo professor", example = "1")
        Long subjectId
) {
}
