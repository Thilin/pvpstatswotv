package com.mxhstudio.pvpstatswotv.repository;

import com.mxhstudio.pvpstatswotv.domain.CharacterBuiltSupportAbility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterBuiltSupportAbilityRepository extends JpaRepository<CharacterBuiltSupportAbility, Long> {
    List<CharacterBuiltSupportAbility> findByCharacterBuiltId(Long id);
}
