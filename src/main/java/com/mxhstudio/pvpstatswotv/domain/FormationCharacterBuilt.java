package com.mxhstudio.pvpstatswotv.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_formation_character_built")
public class FormationCharacterBuilt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FCB_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FCB_FMT_ID")
    private Formation formation;

    @Column(name = "FCB_POSITION")
    private Long position;

    @ManyToOne
    @JoinColumn(name = "FCB_CHB_ID")
    private CharacterBuilt characterBuilt;
}
