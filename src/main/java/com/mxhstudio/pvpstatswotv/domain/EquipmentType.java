package com.mxhstudio.pvpstatswotv.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_equipment_type")
public class EquipmentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ETY_ID")
    private Long id;

    @Column(name = "ETY_DESCRIPTION")
    private String description;
}
