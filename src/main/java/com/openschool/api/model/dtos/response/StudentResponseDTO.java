package com.openschool.api.model.dtos.response;

import com.openschool.api.model.Address;
import com.openschool.api.model.entity.Student;
import com.openschool.api.model.entity.Subject;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.List;

@Schema(name = "student response dto", description = "dto de resposta para estudante")
public record StudentResponseDTO(

        @Schema(description = "id do estudante", example = "1")
        Long id,

        @Schema(description = "nome do estudante", example = "João")
        String name,

        @Schema(description = "data de nascimento do estudante", example = "2000-01-01")
        LocalDate birthdate,

        @Schema(description = "email do estudante", example = "estudante@email.com")
        String email,

        @Schema(description = "endereço do estudante")
        Address address,

        @Schema(description = "disciplinas do estudante")
        List<Subject> subjects
) {
        public StudentResponseDTO(Student student) {
                this(student.getId(), student.getName(), student.getBirthdate(), student.getEmail(), student.getAddress(), student.getSubjects());
        }
}
