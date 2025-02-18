package com.openschool.api.model.dtos.request;
import com.openschool.api.model.entity.Subject;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public record StudentRequestDTO(
        @NotBlank(message = "O nome é obrigatório")
        @Size(max=100, message = "O nome deve ter no máximo 100 caracteres")
        @Schema(description = "Nome do estudante", example = "João")
        String name,

        @NotNull(message = "A data de nascimento é obrigatória")
        @Schema(description = "Data de nascimento do estudante", example = "2000-01-01")
        LocalDate birthdate,

        @Email(message = "O email tem que ser válido")
        @Schema(description = "Email do estudante", example = "estudante@email.com")
        String email,

        @NotNull(message = "O endereço é obrigatório")
        @Valid
        AddressRequestDTO address,

        @NotNull(message = "As disciplinas são obrigatórias")
        List<Subject> subjects

) {
}
