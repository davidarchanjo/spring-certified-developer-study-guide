package io.davidarchanjo.code.controller;

import io.davidarchanjo.code.config.JwtTokenUtil;
import io.davidarchanjo.code.model.dto.CreateUserDTO;
import io.davidarchanjo.code.model.dto.LoginDTO;
import io.davidarchanjo.code.model.dto.UserDTO;
import io.davidarchanjo.code.service.AuthService;
import io.davidarchanjo.code.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
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
