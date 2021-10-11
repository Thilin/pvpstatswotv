package com.mxhstudio.pvpstatswotv.controller;

import com.mxhstudio.pvpstatswotv.dto.LoginDTO;
import com.mxhstudio.pvpstatswotv.dto.TokenDTO;
import com.mxhstudio.pvpstatswotv.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<TokenDTO> authenticate(@RequestBody @Valid LoginDTO dto){
        UsernamePasswordAuthenticationToken dadosLogin = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());
        var authentication = authManager.authenticate(dadosLogin);
        String token = tokenService.generateToken(authentication);
        return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
    }
}
