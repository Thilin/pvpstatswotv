package com.mxhstudio.pvpstatswotv.controller;

import com.mxhstudio.pvpstatswotv.dto.CharacterBuiltCreateDTO;
import com.mxhstudio.pvpstatswotv.dto.CharacterBuiltResponseDTO;
import com.mxhstudio.pvpstatswotv.service.CharacterBuiltService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/builders")
public class CharacterBuilderController {

    private final CharacterBuiltService characterBuiltService;

    CharacterBuilderController(CharacterBuiltService characterBuiltService){
        this.characterBuiltService = characterBuiltService;
    }

    @PutMapping(consumes = "application/json")
    @Operation(summary = "Build character", description = "Build a new character with equipments, esper, vcs, etc")
    public ResponseEntity<Void> crate(@RequestBody CharacterBuiltCreateDTO dto){
        long id = characterBuiltService.create(dto);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{userId}")
    public List<CharacterBuiltResponseDTO> listAllByUserId(@PathVariable Long userId){
        return characterBuiltService.listAllByUserId(userId);
    }
}
