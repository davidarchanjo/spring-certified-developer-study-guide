package io.example.controller;

import io.example.config.JwtTokenUtil;
import io.example.model.dto.CreateUserDTO;
import io.example.model.dto.LoginDTO;
import io.example.model.dto.UserDTO;
import io.example.service.AuthService;
import io.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("auth")
@RestController 
public class AuthController {

    private final JwtTokenUtil jwtTokenUtil;
    private final UserService userService;
    private final AuthService authService;

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginDTO dto) {
        final UserDTO body = authService.login(dto.getUsername(), dto.getPassword());
        return ResponseEntity.ok()
            .header(HttpHeaders.AUTHORIZATION, jwtTokenUtil.generateAccessToken(body))
            .body(body);
    }

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody @Valid CreateUserDTO dto) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(userService.create(dto));
    }

}
