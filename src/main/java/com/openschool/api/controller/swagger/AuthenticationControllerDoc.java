package com.openschool.api.controller.swagger;

import com.openschool.api.model.dtos.request.AuthenticationRequestDTO;
import com.openschool.api.model.dtos.response.AuthenticationResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "authentication controller", description = "autenticação de usuário")
public interface AuthenticationControllerDoc {

    @Operation(summary = "autenticar usuário", description = "autentica um usuário com os dados fornecidos")
    @ApiResponse(responseCode = "200", description = "usuário autenticado com sucesso")
    public ResponseEntity<AuthenticationResponseDTO> login(
            @Parameter(description = "dados do usuário") @Valid @RequestBody AuthenticationRequestDTO data
    );
}
