package com.lafiray.springboot.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SousCategorieEnum {
    FREINS_A_DISQUE("FREIN_A_DISQUE"),
    FREINS_A_TAMBOUR("FREINS_A_TAMBOUR");

    private String sousCategorieLabel;
}
