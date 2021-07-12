package com.mxhstudio.pvpstatswotv.service.impl;

import com.mxhstudio.pvpstatswotv.dto.CharacterJobResponseDTO;
import com.mxhstudio.pvpstatswotv.dto.CharacterResponseDTO;
import com.mxhstudio.pvpstatswotv.exceptions.ObjectNotFoundException;
import com.mxhstudio.pvpstatswotv.repository.CharacterJobRepository;
import com.mxhstudio.pvpstatswotv.repository.CharacterRepository;
import com.mxhstudio.pvpstatswotv.service.CharacterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.mxhstudio.pvpstatswotv.exceptions.ErrorConstants.*;
import static com.mxhstudio.pvpstatswotv.mapper.CharacterMapper.*;

@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepository;
    private final CharacterJobRepository characterJobRepository;

    CharacterServiceImpl(CharacterRepository characterRepository, CharacterJobRepository characterJobRepository){
        this.characterRepository = characterRepository;
        this.characterJobRepository = characterJobRepository;
    }

    @Override
    public CharacterResponseDTO findById(Long id) {
        var character = characterRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException(CHARACTER_NAO_ENCONTRADO));
        return INSTANCE.convertToDTO(character);
    }

    @Override
    public List<CharacterResponseDTO> listAll() {
        var characters = characterRepository.findAll();
        return characters.stream().map(INSTANCE::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<CharacterJobResponseDTO> listAllJobsByCharacterId(Long id) {
        var characterJobs = characterJobRepository.findByCharacterId(id);
        return characterJobs.stream().map(INSTANCE::convertJobsToDTO).collect(Collectors.toList());
    }
}
