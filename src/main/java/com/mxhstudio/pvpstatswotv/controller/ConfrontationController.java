package com.mxhstudio.pvpstatswotv.controller;

import com.mxhstudio.pvpstatswotv.dto.ConfrontationCreateDTO;
import com.mxhstudio.pvpstatswotv.service.ConfrontationService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/confrontations")
public class ConfrontationController {

    private final ConfrontationService confrontationService;

    ConfrontationController(ConfrontationService confrontationService){
        this.confrontationService = confrontationService;
    }

    @PutMapping
    public Long create(@RequestBody ConfrontationCreateDTO dto){
        return confrontationService.create(dto);
    }
}
