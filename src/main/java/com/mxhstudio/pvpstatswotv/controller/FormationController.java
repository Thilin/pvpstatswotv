package com.mxhstudio.pvpstatswotv.controller;

import com.mxhstudio.pvpstatswotv.dto.CharacterFormationCreateDTO;
import com.mxhstudio.pvpstatswotv.dto.FormationResumeResponseDTO;
import com.mxhstudio.pvpstatswotv.service.FormationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/{userId}")
    public List<FormationResumeResponseDTO> listAllByUserId(@PathVariable Long userId){
        return formationService.listAllByUserId(userId);
    }
}
