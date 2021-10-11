package com.mxhstudio.pvpstatswotv.service;

import com.mxhstudio.pvpstatswotv.dto.ConfrontationCreateDTO;
import com.mxhstudio.pvpstatswotv.dto.UsedFormationResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ConfrontationService {

    Long create(ConfrontationCreateDTO dto);

    List<UsedFormationResponseDTO> findMostUsedFormationsByPvPTypeAndSeason(Long pvpTypeId, Long seasonId);

    Object findFormationsWithBestWinrateBySeason(Long seasonId);
}
