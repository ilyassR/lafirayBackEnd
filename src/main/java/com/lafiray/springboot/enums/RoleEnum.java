package com.lafiray.springboot.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RoleEnum {
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_USER("ROLE_USER"),
    ROLE_VISITOR("ROLE_VISITOR");

    private final String roleName;
}
