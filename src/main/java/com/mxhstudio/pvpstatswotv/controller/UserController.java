package com.mxhstudio.pvpstatswotv.controller;

import com.mxhstudio.pvpstatswotv.domain.User;
import com.mxhstudio.pvpstatswotv.dto.UserCreateDTO;
import com.mxhstudio.pvpstatswotv.dto.UserResponseDTO;
import com.mxhstudio.pvpstatswotv.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }

    @PutMapping(consumes = "application/json")
    @Operation(summary = "Create new user", description = "Create a new user")
    public ResponseEntity<Void> create(@RequestBody UserCreateDTO dto){
        long id = userService.create(dto);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }
}
