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
@Table(name = "tb_confrontation")
public class Confrontation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CON_ID")
    private Long id;

    @Column(name = "CON_DATE")
    private LocalDate date;

    @OneToOne
    @JoinColumn(name = "CON_FMT_ID", referencedColumnName = "FMT_ID")
    private Formation formation;

    @Column(name = "CON_ISWIN")
    private boolean isWin;

    @OneToOne
    @JoinColumn(name = "CON_USR_ID", referencedColumnName = "USR_ID")
    private User user;

    @OneToOne
    @JoinColumn(name = "CON_CCF_ID", referencedColumnName = "CCF_ID")
    private ConfrontationCharacterFormation confrontationCharacterFormation;

    @OneToOne
    @JoinColumn(name = "CON_SEA_ID", referencedColumnName = "SEA_ID")
    private Season season;
}
