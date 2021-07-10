package com.mxhstudio.pvpstatswotv.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_character_built_equipment")
public class CharacterBuiltEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHE_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CHE_EQP_ID")
    private Equipment equipment;

    @ManyToOne
    @JoinColumn(name = "CHE_CHB_ID")
    private CharacterBuilt characterBuilt;
}
