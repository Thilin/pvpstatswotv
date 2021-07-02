package com.mxhstudio.pvpstatswotv.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_element")
@Entity
public class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ELE_ID")
    private Long id;

    @Column(name = "ELE_DESCRIPTION")
    private String description;

    @Column(name = "ELE_IMAGE")
    private String image;
}
