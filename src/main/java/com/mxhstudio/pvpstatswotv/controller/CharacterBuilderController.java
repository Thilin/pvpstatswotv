package com.mxhstudio.pvpstatswotv.controller;

import com.mxhstudio.pvpstatswotv.dto.CharacterBuiltCreateDTO;
import com.mxhstudio.pvpstatswotv.dto.CharacterBuiltResponseDTO;
import com.mxhstudio.pvpstatswotv.service.CharacterBuiltService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/builder")
public class CharacterBuilderController {

    private final CharacterBuiltService characterBuiltService;

    CharacterBuilderController(CharacterBuiltService characterBuiltService){
        this.characterBuiltService = characterBuiltService;
    }

    @PutMapping
    public Long crate(@RequestBody CharacterBuiltCreateDTO dto){
        return characterBuiltService.create(dto);
    }

    @GetMapping(value = "/{userId}")
    public List<CharacterBuiltResponseDTO> listAllByUserId(@PathVariable Long userId){
        return characterBuiltService.listAllByUserId(userId);
    }
}
