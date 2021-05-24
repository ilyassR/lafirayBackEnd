package com.lafiray.springboot.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PrivilegeEnum {

    READ_PRIVILEGE("READ_PRIVILEGE"),
    WRITE_PRIVILEGE("WRITE_PRIVILEGE");

    private final String privilegeName;
}
