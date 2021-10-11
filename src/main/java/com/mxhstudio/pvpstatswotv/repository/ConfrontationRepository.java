package com.mxhstudio.pvpstatswotv.repository;

import com.mxhstudio.pvpstatswotv.domain.Confrontation;
import com.mxhstudio.pvpstatswotv.dto.UsedFormationResponseDTO;
import com.mxhstudio.pvpstatswotv.dto.WinFormationDTO;
import com.mxhstudio.pvpstatswotv.dto.WinrateFormationResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConfrontationRepository extends JpaRepository<Confrontation, Long> {
    List<Confrontation> findBySeasonId(Long seasonId);

    @Query(" SELECT new com.mxhstudio.pvpstatswotv.dto.UsedFormationResponseDTO(ccf.character1, ccf.character2, ccf.character3, count(con.confrontationCharacterFormation.id)) from Confrontation  con " +
            " inner join ConfrontationCharacterFormation  ccf on con.confrontationCharacterFormation.id = ccf.id " +
            " where con.season.id = :seasonId group by ccf.id order by count(con.confrontationCharacterFormation.id) DESC ")
    List<UsedFormationResponseDTO> findMostUsedFormationsBySeasonId(@Param("seasonId") Long seasonId);

    @Query(" select new com.mxhstudio.pvpstatswotv.dto.WinFormationDTO(con.confrontationCharacterFormation.id, ccf.character1, ccf.character2, ccf.character3, count(con.confrontationCharacterFormation.id)) from Confrontation  con " +
            " inner join ConfrontationCharacterFormation  ccf on con.confrontationCharacterFormation.id = ccf.id " +
            "where con.isWin=true group by con.confrontationCharacterFormation.id order by count(con.confrontationCharacterFormation.id)")
    List<WinFormationDTO> countAllWinFormations();

    Long countByConfrontationCharacterFormationId(Long ccfId);
}
