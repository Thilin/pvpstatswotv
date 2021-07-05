package com.mxhstudio.pvpstatswotv.service.impl;

import com.mxhstudio.pvpstatswotv.dto.CharacterResponseDTO;
import com.mxhstudio.pvpstatswotv.exceptions.ErrorConstants;
import com.mxhstudio.pvpstatswotv.exceptions.ObjectNotFoundException;
import com.mxhstudio.pvpstatswotv.mapper.CharacterMapper;
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

    CharacterServiceImpl(CharacterRepository characterRepository){
        this.characterRepository = characterRepository;
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
}
