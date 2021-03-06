package com.mxhstudio.pvpstatswotv.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_character_job")
@Data
public class CharacterJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CJO_ID")
    private Long id;

    @Column(name = "CJO_ISMAIN")
    private boolean isMain;

    @ManyToOne
    @JoinColumn(name = "CJO_JOB_ID")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "CJO_CTR_ID")
    private Character character;
}
