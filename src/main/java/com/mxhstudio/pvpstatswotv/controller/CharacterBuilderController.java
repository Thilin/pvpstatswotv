package com.mxhstudio.pvpstatswotv.controller;

import com.mxhstudio.pvpstatswotv.dto.CharacterBuiltCreateDTO;
import com.mxhstudio.pvpstatswotv.service.CharacterBuiltService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
