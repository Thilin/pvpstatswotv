package com.mxhstudio.pvpstatswotv.controller;

import com.mxhstudio.pvpstatswotv.dto.EsperResponseDTO;
import com.mxhstudio.pvpstatswotv.service.EsperService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/espers")
public class EsperController {

    private final EsperService esperService;

    public EsperController(EsperService esperService){
        this.esperService = esperService;
    }

    @GetMapping(value = "/{id}")
    public EsperResponseDTO findById(@PathVariable Long id){
        return esperService.findById(id);
    }

    @GetMapping(value = "/all")
    public List<EsperResponseDTO> listAll(){
        return esperService.showAll();
    }
}
