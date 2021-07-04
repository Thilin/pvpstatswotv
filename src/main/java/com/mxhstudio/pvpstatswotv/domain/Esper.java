package com.mxhstudio.pvpstatswotv.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_esper")
public class Esper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ESP_ID")
    private Long id;

    @Column(name = "ESP_NAME")
    private String name;

    @Column(name = "ESP_IMAGE")
    private String image;

    @Column(name = "ESP_RARITY")
    private String rarity;

    @OneToOne
    @JoinColumn(name = "ESP_ELE_ID", referencedColumnName = "ELE_ID")
    private Element element;
}
