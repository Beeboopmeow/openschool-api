package com.openschool.api.model.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationRequestDTO(

        @NotBlank
        String username,

        @NotBlank
        String password
) {
}
