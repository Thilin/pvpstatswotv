package com.mxhstudio.pvpstatswotv.service;

import com.mxhstudio.pvpstatswotv.dto.EsperResponseDTO;

import java.util.List;

public interface EsperService {

    EsperResponseDTO findById(Long id);
    List<EsperResponseDTO> showAll();
}
