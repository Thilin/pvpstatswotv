package com.mxhstudio.pvpstatswotv.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_season")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEA_ID")
    private Long id;

    @Column(name = "SEA_CODE")
    private Long code;

    @Column(name = "SEA_DATE_START")
    private LocalDate dateStart;

    @Column(name = "SEA_DATE_END")
    private LocalDate dateEnd;

    @OneToOne
    @JoinColumn(name = "SEA_CTY_ID", referencedColumnName = "CTY_ID")
    private ConfrontationType confrontationType;

    @OneToOne
    @JoinColumn(name = "SEA_MAP_ID", referencedColumnName = "MAP_ID")
    private Map map;

    @Column(name = "SEA_DESCRIPTION")
    private String description;
}
