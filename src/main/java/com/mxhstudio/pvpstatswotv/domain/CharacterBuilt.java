package com.mxhstudio.pvpstatswotv.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_character_built")
public class CharacterBuilt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHB_ID")
    private Long id;

    @Column(name = "CHB_NAME")
    private String name;

    @OneToOne
    @JoinColumn(name = "CHB_VCD_ID", referencedColumnName = "VCD_ID")
    private VisionCard visionCard;

    @OneToOne
    @JoinColumn(name = "CHB_ESP_ID", referencedColumnName = "ESP_ID")
    private Esper esper;

    @OneToOne
    @JoinColumn(name = "CHB_CTR_ID", referencedColumnName = "CTR_ID")
    private Character character;

    @OneToOne
    @JoinColumn(name = "CHB_USR_ID", referencedColumnName = "USR_ID")
    private User user;

    @OneToOne
    @JoinColumn(name = "CHB_REA_ID", referencedColumnName = "REA_ID")
    private Reaction reaction;
}
