package com.mxhstudio.pvpstatswotv.service;

import com.mxhstudio.pvpstatswotv.dto.ConfrontationCreateDTO;
import com.mxhstudio.pvpstatswotv.dto.UsedFormationResponseDTO;

import java.util.List;

public interface ConfrontationService {

    Long create(ConfrontationCreateDTO dto);

    List<UsedFormationResponseDTO> findMostUsedFormationsByPvPTypeAndSeason(Long seasonId);

    Object findFormationsWithBestWinrateBySeason(Long seasonId);
}
