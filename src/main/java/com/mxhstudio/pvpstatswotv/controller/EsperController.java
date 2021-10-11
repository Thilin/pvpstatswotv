package com.mxhstudio.pvpstatswotv.controller;

import com.mxhstudio.pvpstatswotv.dto.EsperResponseDTO;
import com.mxhstudio.pvpstatswotv.service.EsperService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/espers")
@SecurityRequirement(name = "/v3/api-docs")
public class EsperController {

    private final EsperService esperService;

    public EsperController(EsperService esperService){
        this.esperService = esperService;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @Operation(summary = "find esper", description = "Find an Esper using its id")
    public ResponseEntity<EsperResponseDTO> findById(@PathVariable Long id){
        var dto = esperService.findById(id);
        if(dto == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/all", produces = "application/json")
    @Operation(summary = "list all espers", description = "List all espers with their infos")
    public ResponseEntity<List<EsperResponseDTO>> listAll(){
        return ResponseEntity.ok().body(esperService.showAll());
    }
}
