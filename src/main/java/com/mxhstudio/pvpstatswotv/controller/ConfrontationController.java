package com.mxhstudio.pvpstatswotv.controller;

import com.mxhstudio.pvpstatswotv.dto.ConfrontationCreateDTO;
import com.mxhstudio.pvpstatswotv.dto.UsedFormationResponseDTO;
import com.mxhstudio.pvpstatswotv.service.ConfrontationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/confrontations")
@SecurityRequirement(name = "/v3/api-docs")
public class ConfrontationController {

    private final ConfrontationService confrontationService;

    ConfrontationController(ConfrontationService confrontationService){
        this.confrontationService = confrontationService;
    }

    @PutMapping(produces = "application/json")
    @Operation(summary = "register confrontation", description = "register the confrontation result")
    public ResponseEntity<Void> create(@RequestBody ConfrontationCreateDTO dto){
        long id = confrontationService.create(dto);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/mostUsedFormation", produces = "application/json")
    @Operation(summary = "Show formations", description = "Show all most used formations by pvpType and season")
    public ResponseEntity<List<UsedFormationResponseDTO>> listMostUsedFormationByPvPTypeAndSeason( @RequestParam Long seasonId){
        var formations =  confrontationService.findMostUsedFormationsByPvPTypeAndSeason(seasonId);
        return ResponseEntity.ok().body(formations);
    }

    @GetMapping(value = "/winrateFormation", produces = "application/json")
    @Operation(summary = "Show formation winrate", description = "Show all formations winrate")
    public ResponseEntity<?> listFormationsWithBestWinrateBySeaon(@RequestParam Long seasonId){
        return ResponseEntity.ok().body(confrontationService.findFormationsWithBestWinrateBySeason(seasonId));
    }

}
