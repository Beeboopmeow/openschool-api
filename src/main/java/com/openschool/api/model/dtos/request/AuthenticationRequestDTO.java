package com.openschool.api.model.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record AuthenticationRequestDTO(

        @NotBlank
        @Schema(description = "nome de usuário, por padrão, admin", example = "admin")
        String username,

        @NotBlank
        @Schema(description = "senha, por padrão, 123", example = "123")
        String password
) {
}
