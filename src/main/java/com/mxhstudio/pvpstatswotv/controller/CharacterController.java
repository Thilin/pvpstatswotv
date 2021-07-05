package com.mxhstudio.pvpstatswotv.controller;

import com.mxhstudio.pvpstatswotv.dto.CharacterResponseDTO;
import com.mxhstudio.pvpstatswotv.service.CharacterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/characters")
public class CharacterController {

    private final CharacterService characterService;

    CharacterController(CharacterService characterService){
        this.characterService = characterService;
    }

    @GetMapping(value = "/{id}")
    public CharacterResponseDTO findById(@PathVariable Long id){
        return characterService.findById(id);
    }

    @GetMapping(value = "/all")
    public List<CharacterResponseDTO> listAll(){
        return characterService.listAll();
    }
}
