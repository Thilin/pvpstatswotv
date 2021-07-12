package com.mxhstudio.pvpstatswotv.repository;

import com.mxhstudio.pvpstatswotv.domain.CharacterJob;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterJobRepository  extends JpaRepository<CharacterJob, Long> {
    List<CharacterJob> findByCharacterId(Long id);
}
