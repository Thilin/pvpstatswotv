package com.mxhstudio.pvpstatswotv.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_formation")
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FMT_ID")
    private Long id;

    @Column(name = "FMT_NAME")
    private String name;

    @OneToOne
    @JoinColumn(name = "FMT_USR_ID", referencedColumnName = "USR_ID")
    private User user;
}
