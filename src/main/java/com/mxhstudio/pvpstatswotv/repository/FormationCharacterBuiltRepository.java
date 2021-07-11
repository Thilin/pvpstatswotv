package com.mxhstudio.pvpstatswotv.repository;

import com.mxhstudio.pvpstatswotv.domain.FormationCharacterBuilt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormationCharacterBuiltRepository extends JpaRepository<FormationCharacterBuilt, Long> {
    List<FormationCharacterBuilt> findByFormationId(Long id);
}
