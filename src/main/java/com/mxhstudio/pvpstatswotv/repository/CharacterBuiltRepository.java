package com.mxhstudio.pvpstatswotv.repository;

import com.mxhstudio.pvpstatswotv.domain.CharacterBuilt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterBuiltRepository extends JpaRepository<CharacterBuilt, Long> {
    List<CharacterBuilt> findByUserId(Long id);
}
