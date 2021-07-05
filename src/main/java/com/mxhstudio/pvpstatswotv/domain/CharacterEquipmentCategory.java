package com.mxhstudio.pvpstatswotv.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_character_equipment_category")
public class CharacterEquipmentCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CEC_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CEC_CTR_ID")
    private Character character;

    @ManyToOne
    @JoinColumn(name = "CEC_ECA_ID")
    private EquipmentCategory equipmentCategory;
}
