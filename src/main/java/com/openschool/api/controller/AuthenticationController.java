package com.openschool.api.controller;

import com.openschool.api.infra.security.TokenService;
import com.openschool.api.model.dtos.request.AuthenticationRequestDTO;
import com.openschool.api.model.dtos.response.AuthenticationResponseDTO;
import com.openschool.api.model.entity.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/login")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity<AuthenticationResponseDTO> login(@Valid @RequestBody AuthenticationRequestDTO data) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var authentication = authenticationManager.authenticate(authenticationToken);
        var JWTToken = tokenService.generateToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new AuthenticationResponseDTO(JWTToken));
    }
}
