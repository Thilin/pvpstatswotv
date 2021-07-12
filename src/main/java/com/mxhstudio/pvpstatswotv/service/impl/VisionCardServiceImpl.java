package com.mxhstudio.pvpstatswotv.service.impl;

import com.mxhstudio.pvpstatswotv.dto.VisionCardResponseDTO;
import com.mxhstudio.pvpstatswotv.exceptions.ObjectNotFoundException;
import com.mxhstudio.pvpstatswotv.repository.VisionCardRepository;
import com.mxhstudio.pvpstatswotv.service.VisionCardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.mxhstudio.pvpstatswotv.exceptions.ErrorConstants.*;
import static com.mxhstudio.pvpstatswotv.mapper.VisionCardMapper.*;

@Service
public class VisionCardServiceImpl implements VisionCardService {

    private final VisionCardRepository visionCardRepository;

    VisionCardServiceImpl(VisionCardRepository visionCardRepository){
        this.visionCardRepository = visionCardRepository;
    }

    @Override
    public VisionCardResponseDTO findById(Long id) {
        var visionCard = visionCardRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException(VISION_CARD_NAO_ENCONTRADO));
        return INSTANCE.convertToDTO(visionCard);
    }

    @Override
    public List<VisionCardResponseDTO> listAll() {
        var visionCards = visionCardRepository.findAll();
        return visionCards.stream().map(INSTANCE::convertToDTO).collect(Collectors.toList());
    }
}
