package com.mxhstudio.pvpstatswotv.controller;

import com.mxhstudio.pvpstatswotv.dto.VisionCardResponseDTO;
import com.mxhstudio.pvpstatswotv.service.VisionCardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/visioncards")
@SecurityRequirement(name = "/v3/api-docs")
public class VisionCardController {

    private final VisionCardService visionCardService;

    VisionCardController(VisionCardService visionCardService){
        this.visionCardService = visionCardService;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @Operation(summary = "Find VisionCard", description = "Find a VisionCard using its id")
    public ResponseEntity<VisionCardResponseDTO> findById(@PathVariable Long id){
        var dto = visionCardService.findById(id);
        if(dto == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(visionCardService.findById(id));
    }

    @GetMapping(value = "/all", produces = "application/json")
    @Operation(summary = "List all Vision cards", description = "List all vision cards with their infos")
    public ResponseEntity<List<VisionCardResponseDTO>> listAll(){
        return ResponseEntity.ok().body(visionCardService.listAll());
    }
}
