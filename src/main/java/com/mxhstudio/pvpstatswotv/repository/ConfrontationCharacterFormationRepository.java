package com.mxhstudio.pvpstatswotv.repository;

import com.mxhstudio.pvpstatswotv.domain.ConfrontationCharacterFormation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfrontationCharacterFormationRepository extends JpaRepository<ConfrontationCharacterFormation, Long> {

    ConfrontationCharacterFormation  findByCharacter1AndAndCharacter2AndCharacter3(String name1, String name2, String name3);
    boolean existsByCharacter1AndAndCharacter2AndCharacter3(String name1, String name2, String name3);
}
