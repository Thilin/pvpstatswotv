package com.mxhstudio.pvpstatswotv.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_vision_card")
public class VisionCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VCD_ID")
    private Long id;

    @Column(name = "VCD_NAME")
    private String description;

    @Column(name = "VCD_IMAGE")
    private String image;
}
