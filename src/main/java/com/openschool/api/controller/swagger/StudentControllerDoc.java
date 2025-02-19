package com.openschool.api.controller.swagger;

import com.openschool.api.model.dtos.request.StudentRequestDTO;
import com.openschool.api.model.dtos.response.StudentResponseDTO;
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

@Tag(name = "student controller", description = "controlador de estudantes")
public interface StudentControllerDoc {

    @Operation(summary = "buscar estudante por id", description = "retorna um estudante pelo id informado no parâmetro")
    @ApiResponse(responseCode = "200", description = "estudante encontrado com sucesso")
    ResponseEntity<StudentResponseDTO> getStudentById(
            @Parameter(description = "id do estudante a ser buscado") @PathVariable Long id
    );

    @Operation(summary = "listar todos os estudantes", description = "retorna uma lista com todos os estudantes cadastrados com paginação")
    @ApiResponse(responseCode = "200", description = "estudantes listados com sucesso")
    ResponseEntity<Page<StudentResponseDTO>> getStudents(
            @ParameterObject Pageable pageable
            );

    @Operation(summary = "criar um novo estudante", description = "cria um novo estudante com os dados fornecidos")
    @ApiResponse(responseCode = "201", description = "estudante criado com sucesso")
    ResponseEntity<StudentResponseDTO> createStudent(
            @Parameter(description = "dados do novo estudante") @RequestBody @Valid StudentRequestDTO studentRequestDTO
    );

    @Operation(summary = "atualizar um estudante", description = "atualiza os dados de um estudante existente pelo id informado")
    @ApiResponse(responseCode = "200", description = "estudante atualizado com sucesso")
    ResponseEntity<StudentResponseDTO> updateStudent(
            @Parameter(description = "id do estudante a ser atualizado") @PathVariable Long id,
            @Parameter(description = "novos dados do estudante") @RequestBody @Valid StudentRequestDTO studentRequestDTO
    );

    @Operation(summary = "deletar um estudante", description = "deleta um estudante existente pelo id informado")
    @ApiResponse(responseCode = "204", description = "estudante deletado com sucesso")
    ResponseEntity<Void> deleteStudent(
            @Parameter(description = "id do estudante a ser deletado") @PathVariable Long id
    );


}
