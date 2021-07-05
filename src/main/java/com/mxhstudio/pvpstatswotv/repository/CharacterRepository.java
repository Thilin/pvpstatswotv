package com.mxhstudio.pvpstatswotv.repository;

import com.mxhstudio.pvpstatswotv.domain.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {
}
