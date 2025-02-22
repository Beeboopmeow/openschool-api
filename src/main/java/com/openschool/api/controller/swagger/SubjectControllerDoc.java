package com.openschool.api.controller.swagger;

import com.openschool.api.model.dtos.request.SubjectRequestDTO;
import com.openschool.api.model.dtos.response.SubjectResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "subject controller", description = "controlador de disciplinas")
@SecurityRequirement(name = "bearer-key")
public interface SubjectControllerDoc {
    @Operation(summary = "buscar disciplina por id", description = "retorna uma disciplina pelo id informado no parâmetro")
    @ApiResponse(responseCode = "200", description = "disciplina encontrada com sucesso")
    ResponseEntity<SubjectResponseDTO> getSubjectById(
            @Parameter(description = "id da disciplina a ser buscada") @PathVariable Long id
    );

    @Operation(summary = "listar todas as disciplinas", description = "retorna uma lista com todas as disciplinas cadastradas com paginação")
    @ApiResponse(responseCode = "200", description = "disciplinas listadas com sucesso")
    ResponseEntity<Page<SubjectResponseDTO>> getSubjects(
            @ParameterObject Pageable pageable
    );

    @Operation(summary = "criar uma nova disciplina", description = "cria uma nova disciplina com os dados fornecidos")
    @ApiResponse(responseCode = "201", description = "disciplina criada com sucesso")
    ResponseEntity<SubjectResponseDTO> createSubject(
            @Parameter(description = "dados da nova disciplina") @RequestBody @Valid SubjectRequestDTO subjectRequestDTO
    );

    @Operation(summary = "atualizar uma disciplina", description = "atualiza os dados de uma disciplina existente pelo id informado")
    @ApiResponse(responseCode = "200", description = "disciplina atualizada com sucesso")
    ResponseEntity<SubjectResponseDTO> updateSubject(
            @Parameter(description = "id da disciplina a ser atualizada") @PathVariable Long id,
            @Parameter(description = "novos dados da disciplina") @RequestBody @Valid SubjectRequestDTO subjectRequestDTO
    );

    @Operation(summary = "deletar uma disciplina", description = "deleta uma disciplina existente pelo id informado")
    @ApiResponse(responseCode = "204", description = "disciplina deletada com sucesso")
    ResponseEntity<Void> deleteSubject(
            @Parameter(description = "id da disciplina a ser deletada") @PathVariable Long id
    );
}
