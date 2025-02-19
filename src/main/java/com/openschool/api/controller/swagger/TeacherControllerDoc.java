package com.openschool.api.controller.swagger;

import com.openschool.api.model.dtos.request.TeacherRequestDTO;
import com.openschool.api.model.dtos.response.TeacherResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "teacher controller", description = "controlador de professores")
public interface TeacherControllerDoc {
    @Operation(summary = "buscar professor por id", description = "retorna um professor pelo id informado no parâmetro")
    @ApiResponse(responseCode = "200", description = "professor encontrado com sucesso")
    ResponseEntity<TeacherResponseDTO> getTeacherById(
            @Parameter(description = "id do professor a ser buscado") @PathVariable Long id
    );

    @Operation(summary = "listar todos os professores", description = "retorna uma lista com todos os professores cadastrados com paginação")
    @ApiResponse(responseCode = "200", description = "professores listados com sucesso")
    ResponseEntity<Page<TeacherResponseDTO>> getTeachers(
            @ParameterObject Pageable pageable
    );

    @Operation(summary = "criar um novo professor", description = "cria um novo professor com os dados fornecidos")
    @ApiResponse(responseCode = "201", description = "professor criado com sucesso")
    ResponseEntity<TeacherResponseDTO> createTeacher(
            @Parameter(description = "dados do novo professor") @RequestBody @Valid TeacherRequestDTO teacherRequestDTO
    );

    @Operation(summary = "atualizar um professor", description = "atualiza os dados de um professor existente pelo id informado")
    @ApiResponse(responseCode = "200", description = "professor atualizado com sucesso")
    ResponseEntity<TeacherResponseDTO> updateTeacher(
            @Parameter(description = "id do professor a ser atualizado") @PathVariable Long id,
            @Parameter(description = "novos dados do professor") @RequestBody @Valid TeacherRequestDTO teacherRequestDTO
    );

    @Operation(summary = "deletar um professor", description = "deleta um professor existente pelo id informado")
    @ApiResponse(responseCode = "204", description = "professor deletado com sucesso")
    ResponseEntity<Void> deleteTeacher(
            @Parameter(description = "id do professor a ser deletado") @PathVariable Long id
    );
}
