package com.lafiray.springboot.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MotorisationEnum {
    DIESEL("DIESEL"),
    ESSENCE("ESSENCE");

    private String motorisationLabel;
}
