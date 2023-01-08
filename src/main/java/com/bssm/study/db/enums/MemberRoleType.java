package com.bssm.study.db.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberRoleType {

    ADMIN("관리자"),
    NORMAL("일반")
    ;
    
    private final String name;
    
}
