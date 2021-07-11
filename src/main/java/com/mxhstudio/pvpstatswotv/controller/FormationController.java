package com.mxhstudio.pvpstatswotv.controller;

import com.mxhstudio.pvpstatswotv.dto.CharacterFormationCreateDTO;
import com.mxhstudio.pvpstatswotv.service.FormationService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/formations")
public class FormationController {

    private final FormationService formationService;

    FormationController(FormationService formationService){
        this.formationService = formationService;
    }

    @PutMapping
    public Long create(@RequestBody CharacterFormationCreateDTO dto){
        return formationService.create(dto);
    }
}
