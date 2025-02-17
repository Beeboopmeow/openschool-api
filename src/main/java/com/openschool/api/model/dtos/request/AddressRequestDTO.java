package com.openschool.api.model.dtos.request;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressRequestDTO(
        @NotBlank(message = "código postal é obrigatório")
        @Pattern(regexp = "\\d{5}-\\d{3}|\\d{8}", message = "Código postal inválido")
        @Schema(description = "Código postal", example = "12345-678 ou 12345678")
        String zipCode,

        @NotBlank(message = "estado é obrigatório")
        @Schema(description = "Estado", example = "Bahia")
        String state,

        @NotBlank(message = "cidade é obrigatória")
        @Schema(description = "Cidade", example = "São Paulo")
        String city,

        @NotBlank(message = "bairro é obrigatório")
        @Schema(description = "Bairro", example = "Centro")
        String neighborhood,

        @Schema(description = "Rua", example = "Rua das Flores")
        String street,

        @Schema(description = "Número residencial", example = "352")
        String number
) {

}
