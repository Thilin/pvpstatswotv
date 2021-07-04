package com.mxhstudio.pvpstatswotv.controller;

import com.mxhstudio.pvpstatswotv.dto.VisionCardResponseDTO;
import com.mxhstudio.pvpstatswotv.service.VisionCardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/visioncards")
public class VisionCardController {

    private final VisionCardService visionCardService;

    VisionCardController(VisionCardService visionCardService){
        this.visionCardService = visionCardService;
    }

    @GetMapping(value = "/{id}")
    public VisionCardResponseDTO findById(@PathVariable Long id){
        return visionCardService.findById(id);
    }

    @GetMapping(value = "/all")
    public List<VisionCardResponseDTO> listAll(){
        return visionCardService.listAll();
    }
}
