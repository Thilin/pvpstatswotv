package com.mxhstudio.pvpstatswotv.repository;

import com.mxhstudio.pvpstatswotv.domain.CharacterBuiltJob;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterBuiltJobRepository extends JpaRepository<CharacterBuiltJob, Long> {
    List<CharacterBuiltJob> findByCharacterBuiltId(Long id);
}
