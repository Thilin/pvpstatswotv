package com.mxhstudio.pvpstatswotv.repository;

import com.mxhstudio.pvpstatswotv.domain.CharacterBuiltEquipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterBuiltEquipmentRepository extends JpaRepository<CharacterBuiltEquipment, Long> {

    List<CharacterBuiltEquipment> findByCharacterBuiltId(Long id);
}
