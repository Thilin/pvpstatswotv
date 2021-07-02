package com.mxhstudio.pvpstatswotv.controller;

import com.mxhstudio.pvpstatswotv.domain.User;
import com.mxhstudio.pvpstatswotv.dto.UserCreateDTO;
import com.mxhstudio.pvpstatswotv.dto.UserResponseDTO;
import com.mxhstudio.pvpstatswotv.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "users/")
public class UserController {

    final private UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "/all", produces = "application/json")
    @Operation(summary = "show all user", description = "Show all user's informations")
    public List<User> listAll(){
        return userService.listAll();
    }

    @PutMapping()
    @Operation(summary = "Create new user", description = "Create a new user")
    public UserResponseDTO create(@RequestBody UserCreateDTO dto){
        return userService.create(dto);
    }
}
