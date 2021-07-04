package com.mxhstudio.pvpstatswotv.service.impl;

import com.mxhstudio.pvpstatswotv.dto.EsperResponseDTO;
import com.mxhstudio.pvpstatswotv.exceptions.ObjectNotFoundException;
import com.mxhstudio.pvpstatswotv.repository.EsperRepository;
import com.mxhstudio.pvpstatswotv.service.EsperService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.mxhstudio.pvpstatswotv.exceptions.ErrorConstants.*;
import static com.mxhstudio.pvpstatswotv.mapper.EsperMapper.*;

@Service
public class EsperServiceImpl implements EsperService {

    private final EsperRepository esperRepository;

    public EsperServiceImpl(EsperRepository esperRepository){
        this.esperRepository = esperRepository;
    }
    @Override
    public EsperResponseDTO findById(Long id) {
        var esper = esperRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(ESPER_NAO_ENCONTRADO));
        return INSTANCE.convertToDTO(esper);
    }

    @Override
    public List<EsperResponseDTO> showAll() {
        var espers = esperRepository.findAll();
        return espers.stream().map(INSTANCE::convertToDTO).collect(Collectors.toList());
    }
}
