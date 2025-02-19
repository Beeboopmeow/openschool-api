package com.openschool.api.model.dtos.response;

import com.openschool.api.model.Address;
import com.openschool.api.model.entity.Subject;
import com.openschool.api.model.entity.Teacher;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "teacher response dto", description = "dto de resposta para professor")
public record TeacherResponseDTO(
        @Schema(description = "id do professor", example = "1")
        Long id,

        @Schema(description = "nome do professor", example = "João")
        String name,

        @Schema(description = "email do professor", example = "professor@email.com")
        String email,

        @Schema(description = "endereço do professor")
        Address address,

        @Schema(description = "cpf do professor")
        String cpf,

        @Schema(description = "disciplina lecionada pelo professor")
        Subject subject
) {
        public TeacherResponseDTO(Teacher teacher) {
                this(teacher.getId(), teacher.getName(), teacher.getEmail(), teacher.getAddress(), teacher.getCpf(), teacher.getSubject());
        }
}
