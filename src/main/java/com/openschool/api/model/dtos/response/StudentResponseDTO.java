package com.openschool.api.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(name = "student response dto", description = "dto de resposta para estudante")
public record StudentResponseDTO(

        Long id,

        String name,

        LocalDateTime birthdate,

        

) {

}
