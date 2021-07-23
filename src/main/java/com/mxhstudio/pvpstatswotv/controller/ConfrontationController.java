package com.mxhstudio.pvpstatswotv.controller;

import com.mxhstudio.pvpstatswotv.dto.ConfrontationCreateDTO;
import com.mxhstudio.pvpstatswotv.service.ConfrontationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/confrontations")
public class ConfrontationController {

    private final ConfrontationService confrontationService;

    ConfrontationController(ConfrontationService confrontationService){
        this.confrontationService = confrontationService;
    }

    @PutMapping(produces = "application/json")
    @Operation(summary = "register confrontation", description = "register the confrontation result")
    public ResponseEntity<Void> create(@RequestBody ConfrontationCreateDTO dto){
        long id = confrontationService.create(dto);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }
}
