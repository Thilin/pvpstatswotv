package com.mxhstudio.pvpstatswotv.service;

import com.mxhstudio.pvpstatswotv.dto.VisionCardResponseDTO;

import java.util.List;

public interface VisionCardService {

    VisionCardResponseDTO findById(Long id);
    List<VisionCardResponseDTO> listAll();
}
